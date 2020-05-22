java.exe "C:\Program Files\Java\jdk1.7.0_40\bin\java"
    -Djava.util.logging.config.file="<TOMCAT_HOME>\conf\logging.properties"
    -Djava.util.logging.manager=org.apache.juli.ClassLoaderLogManager
    -Djava.endorsed.dirs="<TOMCAT_HOME>\endorsed"
    -classpath "<TOMCAT_HOME>\bin\bootstrap.jar;<TOMCAT_HOME>\bin\tomcat-juli.jar"
    -Dcatalina.base="<TOMCAT_HOME>"
    -Dcatalina.home="<TOMCAT_HOME>"
    -Djava.io.tmpdir="<TOMCAT_HOME>\temp"
    org.apache.catalina.startup.Bootstrap  start