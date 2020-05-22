$ java -jar ~/code/jetty/distros/jetty-home-9.4.18.v20190429/start.jar -Dorg.eclipse.jetty.annotations.LEVEL=DEBUG -Dorg.eclipse.jetty.webapp.LEVEL=DEBUG
...(snip)...
2019-05-19 11:15:14.796:DBUG:oeja.AnnotationParser:qtp1571967156-41: Not a class: jni/Darwin/libjffi-1.2.jnilib
2019-05-19 11:15:14.796:DBUG:oeja.AnnotationParser:qtp1571967156-41: Not a class: jni/aarch64-Linux/libjffi-1.2.so
2019-05-19 11:15:14.796:DBUG:oeja.AnnotationParser:qtp1571967156-41: Not a class: jni/arm-Linux/libjffi-1.2.so
2019-05-19 11:15:14.797:DBUG:oeja.AnnotationParser:qtp1571967156-41: Not a class: jni/i386-Linux/libjffi-1.2.so
2019-05-19 11:15:14.797:DBUG:oeja.AnnotationParser:qtp1571967156-41: Not a class: jni/i386-SunOS/libjffi-1.2.so
2019-05-19 11:15:14.797:DBUG:oeja.AnnotationParser:qtp1571967156-41: Not a class: jni/i386-Windows/jffi-1.2.dll
2019-05-19 11:15:14.797:DBUG:oeja.AnnotationParser:qtp1571967156-41: Not a class: jni/ppc-AIX/libjffi-1.2.a
2019-05-19 11:15:14.797:DBUG:oeja.AnnotationParser:qtp1571967156-41: Not a class: jni/ppc64-Linux/libjffi-1.2.so
2019-05-19 11:15:14.800:DBUG:oeja.AnnotationParser:qtp1571967156-41: Not a class: jni/ppc64le-Linux/libjffi-1.2.so
2019-05-19 11:15:14.800:DBUG:oeja.AnnotationParser:qtp1571967156-41: Not a class: jni/sparcv9-Linux/libjffi-1.2.so
2019-05-19 11:15:14.800:DBUG:oeja.AnnotationParser:qtp1571967156-41: Not a class: jni/sparcv9-SunOS/libjffi-1.2.so
2019-05-19 11:15:14.800:DBUG:oeja.AnnotationParser:qtp1571967156-41: Not a class: jni/x86_64-FreeBSD/libjffi-1.2.so
2019-05-19 11:15:14.800:DBUG:oeja.AnnotationParser:qtp1571967156-41: Not a class: jni/x86_64-Linux/libjffi-1.2.so
2019-05-19 11:15:14.801:DBUG:oeja.AnnotationParser:qtp1571967156-41: Not a class: jni/x86_64-OpenBSD/libjffi-1.2.so
2019-05-19 11:15:14.801:DBUG:oeja.AnnotationParser:qtp1571967156-41: Not a class: jni/x86_64-SunOS/libjffi-1.2.so
2019-05-19 11:15:14.801:DBUG:oeja.AnnotationParser:qtp1571967156-41: Not a class: jni/x86_64-Windows/jffi-1.2.dll
...(snip)...
2019-05-19 11:15:15.393:INFO:oeja.AnnotationConfiguration:main: Scanning elapsed time=654ms
2019-05-19 11:15:15.393:DBUG:oeja.AnnotationConfiguration:main: Scanned file:///home/joakim/code/jetty/distros/jetty-home-9.4.18.v20190429/lib/servlet-api-3.1.jar in 141ms
2019-05-19 11:15:15.393:DBUG:oeja.AnnotationConfiguration:main: Scanned file:///tmp/jetty-0.0.0.0-8080-demo-with-w3j-libs.war-_demo-with-w3j-libs-any-14235900391383929769.dir/webapp/WEB-INF/classes/ in 1ms
2019-05-19 11:15:15.393:DBUG:oeja.AnnotationConfiguration:main: Scanned file:///tmp/jetty-0.0.0.0-8080-demo-with-w3j-libs.war-_demo-with-w3j-libs-any-14235900391383929769.dir/webapp/WEB-INF/lib/Java-WebSocket-1.3.8.jar in 144ms
2019-05-19 11:15:15.393:DBUG:oeja.AnnotationConfiguration:main: Scanned file:///tmp/jetty-0.0.0.0-8080-demo-with-w3j-libs.war-_demo-with-w3j-libs-any-14235900391383929769.dir/webapp/WEB-INF/lib/abi-4.2.0.jar in 163ms
2019-05-19 11:15:15.393:DBUG:oeja.AnnotationConfiguration:main: Scanned file:///tmp/jetty-0.0.0.0-8080-demo-with-w3j-libs.war-_demo-with-w3j-libs-any-14235900391383929769.dir/webapp/WEB-INF/lib/asm-5.0.3.jar in 126ms
...(snip)...
2019-05-19 11:15:15.394:DBUG:oeja.AnnotationConfiguration:main: Scanned 1 container path jars, 31 WEB-INF/lib jars, 1 WEB-INF/classes dirs in 654ms for context o.e.j.w.WebAppContext@75437611{demo-with-w3j-libs,/demo-with-w3j-libs,file:///tmp/jetty-0.0.0.0-8080-demo-with-w3j-libs.war-_demo-with-w3j-libs-any-14235900391383929769.dir/webapp/,STARTING}{/demo-with-w3j-libs.war}