The link for reference **http://www.java-allandsundry.com/2016/05/approaches-to-binding-spring-boot.html** 
Set this configuration in application-cloud.yml for Mysql
---

spring:
  datasource:
    url: ${vcap.services.mydb.credentials.jdbcUrl}
    username: ${vcap.services.mydb.credentials.username}
    password: ${vcap.services.mydb.credentials.password}

    The config for rabbitMq:
System.getEnv("VCAP_SERVICES")