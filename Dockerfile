FROM tomcat:latest
WORKDIR /usr/local/tomcat
COPY target/*.war /usr/local/tomcat/webapps/helloworld.war
CMD /usr/local/tomcat/bin/catalina.sh run
