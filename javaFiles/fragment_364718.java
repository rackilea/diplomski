set JAVA_HOME="C:\Program Files (x86)\Java\jre6"
set CLASSPATH=%JAVA_HOME%\lib\deploy.jar

set BOOTCP=%JAVA_HOME%\lib\javaws.jar;%JAVA_HOME%\lib\deploy.jar;%JAVA_HOME%\lib\plugin.jar
set SECPOL=file:%JAVA_HOME%\lib\security\javaws.policy
set SPLASHPORT="-Djnlpx.splashport=49688"

%JAVA_HOME%\bin\javaw.exe -Xbootclasspath/a:%BOOTCP% -classpath %CLASSPATH% -Djava.security.policy=%SECPOL% -DtrustProxy=true -Xverify:remote -Djnlpx.home=%JAVA_HOME%\bin -Dsun.aws.warmpu=true -Djnlpx.origFilenameArg=C:\opt\kvm\ui.jnlp -Djnlpx.remove=false -Xnoclassgc -XX:PermSize=64m -Xms1028m -Djnlpx.heapsize=1028m,NULL %SPLASHPORT% com.sun.javaws.Main C:\opt\kvm\ui.jnlp