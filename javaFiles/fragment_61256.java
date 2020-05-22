compile("org.springframework.boot:spring-boot-starter-security"){
    exclude module: "spring-boot-starter-logging"
    exclude module: "logback-classic"
}
compile("org.springframework.boot:spring-boot-starter-thymeleaf"){
    exclude module: "logback-classic"
}