set projectLocation=C:\ENVIRONMENT\eclipse\WORKSPACE\PZW_2
cd %projectLocation%
set classpath=%projectLocation%\bin
SET TESTNG_HOME=C:\ENVIRONMENT\java
SET PATH=%PATH%;%JAVA_HOME%\bin;
SET CLASSPATH=%CLASSPATH%;%TESTNG_HOME%\testng- 6.9.9.jar;%TESTNG_HOME%\jcommander-1.27.jar;C:\ENVIRONMENT\java\selenium-server-   standalone-2.53.0.jar
java org.testng.TestNG %projectLocation%\testng.xml
pause