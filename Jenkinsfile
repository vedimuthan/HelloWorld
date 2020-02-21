pipeline {
  agent any
  tools{
    maven 'mvn3'
    jdk 'jdk8'
  }
  stages {
    stage('Initialize'){
      steps {
        sh '''
            echo "PATH=${PATH}"
            echo "M2_HOME=${M2_HOME}"
        '''
      }
    }
    stage('mvnversion') {
      steps {
        sh 'mvn -v'
      }
    }
    stage('SCM Checkout') {
      steps {
        git credentialsId: 'github', url: 'https://github.com/vedimuthan/HelloWorld'
      }
    }
    stage('BUILD') {
      steps {
        withSonarQubeEnv('sonarqube') {
        sh 'mvn clean install sonar:sonar'
        }
      }
    }
    stage('Quality Gate') {
      steps {
        timeout(time: 1, unit: 'MINUTES') {
            def qualitygate = waitForQualityGate()
            if (qualitygate.status != "SUCCESS") {
                error "Pipeline aborted due to quality gate coverage failure: ${qualitygate.status}"
            }
          }
       }
    }
    stage('TEST') {
      steps {
        sh 'mvn test'
      }
    }
  }
}
