INFO: Deploying web application archive spring-boot-web-thymeleaf-1.0.war

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v1.4.2.RELEASE)

2017-04-21 16:45:46.240  INFO 13420 --- [           main] o.s.web.context.ContextLoader            : Root WebApplicationContext: initialization completed in 1492785946240 ms
2017-04-21 16:45:46.263  INFO 13420 --- [           main] org.apache.catalina.startup.Bootstrap    : Starting Bootstrap v6.0.35 on aleksander-K56CB with PID 13420 (/home/aleksander/apache-tomcat-6.0.35/bin/bootstrap.jar started by aleksander in /home/aleksander/apache-tomcat-6.0.35/bin)
2017-04-21 16:45:46.267  INFO 13420 --- [           main] org.apache.catalina.startup.Bootstrap    : No active profile set, falling back to default profiles: default
2017-04-21 16:45:46.778  INFO 13420 --- [           main] onConfigNonEmbeddedWebApplicationContext : Refreshing org.springframework.boot.legacy.context.web.AnnotationConfigNonEmbeddedWebApplicationContext@6a8658ff: startup date [Fri Apr 21 16:45:46 CEST 2017]; root of context hierarchy
2017-04-21 16:45:49.969  INFO 13420 --- [           main] s.w.s.m.m.a.RequestMappingHandlerAdapter : Looking for @ControllerAdvice: org.springframework.boot.legacy.context.web.AnnotationConfigNonEmbeddedWebApplicationContext@6a8658ff: startup date [Fri Apr 21 16:45:46 CEST 2017]; root of context hierarchy
2017-04-21 16:45:50.064  INFO 13420 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/]}" onto public java.lang.String com.mkyong.WelcomeController.welcome(java.util.Map<java.lang.String, java.lang.Object>)
2017-04-21 16:45:50.070  INFO 13420 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/error],produces=[text/html]}" onto public org.springframework.web.servlet.ModelAndView org.springframework.boot.autoconfigure.web.BasicErrorController.errorHtml(javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServletResponse)
2017-04-21 16:45:50.070  INFO 13420 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/error]}" onto public org.springframework.http.ResponseEntity<java.util.Map<java.lang.String, java.lang.Object>> org.springframework.boot.autoconfigure.web.BasicErrorController.error(javax.servlet.http.HttpServletRequest)
2017-04-21 16:45:50.132  INFO 13420 --- [           main] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped URL path [/webjars/**] onto handler of type [class org.springframework.web.servlet.resource.ResourceHttpRequestHandler]
2017-04-21 16:45:50.132  INFO 13420 --- [           main] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped URL path [/**] onto handler of type [class org.springframework.web.servlet.resource.ResourceHttpRequestHandler]
2017-04-21 16:45:50.208  INFO 13420 --- [           main] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped URL path [/**/favicon.ico] onto handler of type [class org.springframework.web.servlet.resource.ResourceHttpRequestHandler]
2017-04-21 16:45:51.215  INFO 13420 --- [           main] o.s.j.e.a.AnnotationMBeanExporter        : Registering beans for JMX exposure on startup
2017-04-21 16:45:51.244  INFO 13420 --- [           main] org.apache.catalina.startup.Bootstrap    : Started Bootstrap in 6.368 seconds (JVM running for 8.515)
2017-04-21 16:45:51.274  INFO 13420 --- [           main] o.s.web.servlet.DispatcherServlet        : FrameworkServlet 'appServlet': initialization started
2017-04-21 16:45:51.296  INFO 13420 --- [           main] o.s.web.servlet.DispatcherServlet        : FrameworkServlet 'appServlet': initialization completed in 22 ms
kwi 21, 2017 4:45:51 PM org.apache.catalina.startup.HostConfig deployDirectory
INFO: Deploying web application directory ROOT
kwi 21, 2017 4:45:51 PM org.apache.catalina.startup.HostConfig deployDirectory
INFO: Deploying web application directory docs
kwi 21, 2017 4:45:51 PM org.apache.catalina.startup.HostConfig deployDirectory
INFO: Deploying web application directory examples
kwi 21, 2017 4:45:51 PM org.apache.coyote.http11.Http11Protocol start
INFO: Starting Coyote HTTP/1.1 on http-8080
kwi 21, 2017 4:45:51 PM org.apache.jk.common.ChannelSocket init
INFO: JK: ajp13 listening on /0.0.0.0:8009
kwi 21, 2017 4:45:51 PM org.apache.jk.server.JkMain start
INFO: Jk running ID=0 time=1/21  config=null
kwi 21, 2017 4:45:51 PM org.apache.catalina.startup.Catalina start
INFO: Server startup in 7930 ms