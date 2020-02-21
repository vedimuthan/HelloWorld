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
        sh 'mvn clean install sonar:sonar'
      }
    }
    stage('TEST') {
      steps {
        sh 'mvn test'
      }
    }
  }
}
