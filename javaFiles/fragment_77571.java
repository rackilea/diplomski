buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:2.0.2.RELEASE")
    }
}

plugins {
   id 'war'
}
apply plugin: 'java'
apply plugin: 'application'
apply plugin: 'org.springframework.boot'
apply plugin: 'io.spring.dependency-management'

sourceCompatibility = 1.8
targetCompatibility = 1.8
mainClassName = 'com.project.foo.bar.Application'


bootJar {
    baseName = 'bar'
    version =  '0.1.0'
}

repositories {
    mavenCentral()
}

dependencies {
    compile("org.springframework.boot:spring-boot-starter-web") {
      exclude module: "spring-boot-starter-tomcat"
    }
    compile("org.springframework.boot:spring-boot-starter-jetty")    
    //compile("org.springframework.boot:spring-boot-starter-web")
    //compile("org.springframework.boot:spring-boot-starter-security")

    // persistence
    compile("org.springframework:spring-orm:4.0.3.RELEASE")
    compile("commons-dbcp:commons-dbcp:1.4")
    compile("org.hibernate:hibernate-core:4.3.11.Final")
    compile("org.hibernate:hibernate-entitymanager:4.3.11.Final")
    runtime('mysql:mysql-connector-java')

    // servlets
    compile("javax.servlet:javax.servlet-api:4.0.1")
    compile("javax.servlet.jsp:javax.servlet.jsp-api:2.3.1")
    // runtime("org.apache.tomcat.embed:tomcat-embed-jasper")
    compile("org.eclipse.jetty:apache-jsp")
    compile "javax.servlet:jstl:1.2"
}