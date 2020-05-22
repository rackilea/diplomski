@echo off
rem -- Check if argument is INSTALL or REMOVE

if not ""%1"" == ""INSTALL"" goto remove

"D:\BitNami\solr-4.5.0-0/apache-solr\scripts\prunsrv.exe" //IS//solrJetty 
--DisplayName="solrJetty" 
--Install="D:\BitNami\solr-4.5.0-0/apache-solr\scripts\prunsrv.exe" 
--LogPath="D:\BitNami\solr-4.5.0-0/apache-solr\logs" 
--LogLevel=Debug 
--StdOutput=auto 
--StdError=auto 
--StartMode=Java 
--StopMode=Java 
--Jvm=auto 
++JvmOptions=-DSTOP.PORT=8079 
++JvmOptions=-DSTOP.KEY=s3crEt 
++JvmOptions=-Djetty.home="D:\BitNami\solr-4.5.0-0/apache-solr" 
++JvmOptions=-Dsolr.solr.home="D:\BitNami\solr-4.5.0-0/apache-solr/solr" 
--Jvm=auto 
++JvmOptions=-Djetty.logs="D:\BitNami\solr-4.5.0-0/apache-solr\logs" 
--JavaHome="D:\BitNami\solr-4.5.0-0\java" 
++JvmOptions=-XX:MaxPermSize=256M 
++JvmOptions=-Xms1024M 
++JvmOptions=-Xmx1024M 
--Classpath="D:\BitNami\solr-4.5.0-0/apache-solr\lib\*";
            "D:\BitNami\solr-4.5.0-0/apache-solr\start.jar" 
--StartClass=org.eclipse.jetty.start.Main 
++StartParams="D:\BitNami\solr-4.5.0-0/apache-solr\etc\jetty.xml" 
--StopClass=org.eclipse.jetty.start.Main 
++StopParams=--stop 
++StopParams=-DSTOP.PORT=8079 
++StopParams=-DSTOP.KEY=s3crEt

net start solrJetty >NUL
goto end

:remove
rem -- STOP SERVICE BEFORE REMOVING

net stop solrJetty >NUL
sc delete solrJetty

:end
exit