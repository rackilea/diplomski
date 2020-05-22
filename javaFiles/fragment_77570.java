compile("org.springframework.boot:spring-boot-starter-web") {
   exclude module: "spring-boot-starter-tomcat"
}
compile("org.springframework.boot:spring-boot-starter-jetty")
compile("org.eclipse.jetty:apache-jsp")
compile "javax.servlet:jstl:1.2"