$ cat start.ini
--module=http
jetty.http.port=8080
--module=deploy
--module=annotations

$ ls -la webapps/
total 10500
drwxr-xr-x 2 joakim joakim     4096 May 19 10:59 ./
drwxr-xr-x 6 joakim joakim     4096 May 19 10:58 ../
-rw-r--r-- 1 joakim joakim 10742370 May 19 10:58 demo-with-w3j-libs.war

$ java -jar ~/code/jetty/distros/jetty-home-9.4.18.v20190429/start.jar 
java -jar ~/code/jetty/distros/jetty-home-9.4.18.v20190429/start.jar
2019-05-19 11:11:02.993:INFO::main: Logging initialized @397ms to org.eclipse.jetty.util.log.StdErrLog
2019-05-19 11:11:03.182:INFO:oejs.Server:main: jetty-9.4.18.v20190429; built: 2019-04-29T20:42:08.989Z; git: e1bc35120a6617ee3df052294e433f3a25ce7097; jvm 11.0.3+7
2019-05-19 11:11:03.195:INFO:oejdp.ScanningAppProvider:main: Deployment monitor [file:///home/joakim/code/jetty/stackoverflow/huge-war/webapps/] at interval 1
2019-05-19 11:11:03.896:INFO:oeja.AnnotationConfiguration:main: Scanning elapsed time=436ms
2019-05-19 11:11:03.902:INFO:oejw.StandardDescriptorProcessor:main: NO JSP Support for /demo-with-w3j-libs, did not find org.eclipse.jetty.jsp.JettyJspServlet
2019-05-19 11:11:03.911:INFO:oejs.session:main: DefaultSessionIdManager workerName=node0
2019-05-19 11:11:03.911:INFO:oejs.session:main: No SessionScavenger set, using defaults
2019-05-19 11:11:03.912:INFO:oejs.session:main: node0 Scavenging every 660000ms
2019-05-19 11:11:03.929:INFO:oejsh.ContextHandler:main: Started o.e.j.w.WebAppContext@75437611{Demo of a WebApp with a large WEB-INF/lib,/demo-with-w3j-libs,file:///tmp/jetty-0.0.0.0-8080-demo-with-w3j-libs.war-_demo-with-w3j-libs-any-5411225940231111244.dir/webapp/,AVAILABLE}{/demo-with-w3j-libs.war}
2019-05-19 11:11:04.236:INFO:oeja.AnnotationConfiguration:main: Scanning elapsed time=184ms
2019-05-19 11:11:04.237:INFO:oejw.StandardDescriptorProcessor:main: NO JSP Support for /huge-war, did not find org.eclipse.jetty.jsp.JettyJspServlet
2019-05-19 11:11:04.240:INFO:oejsh.ContextHandler:main: Started o.e.j.w.WebAppContext@6f7923a5{Demo of a WebApp with a large WEB-INF/lib,/huge-war,file:///tmp/jetty-0.0.0.0-8080-huge-war.war-_huge-war-any-2121417525584312936.dir/webapp/,AVAILABLE}{/huge-war.war}
2019-05-19 11:11:04.295:INFO:oejs.AbstractConnector:main: Started ServerConnector@52c3cb31{HTTP/1.1,[http/1.1]}{0.0.0.0:8080}
2019-05-19 11:11:04.295:INFO:oejs.Server:main: Started @1700ms