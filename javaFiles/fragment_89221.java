CALL SET JAVA_HOME=D:\Java
CALL SET CATALINA_BASE=D:\instance1
CALL SET JAVA_OPTS=-Dport.http=8080
CALL SET JvmArgs=-Dport.http=8080;-Dport.shutdown=8005 // This line did the trick
CALL CD %CATALINA_HOME%\bin
service install instance1