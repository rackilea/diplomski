buildscript {
    ext {
        springBootVersion = '1.5.2.RELEASE'
        springVersion = '4.3.7.RELEASE'
        flywayVersion = '4.1.2'
    }
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:${springBootVersion}")
        classpath("org.flywaydb:flyway-gradle-plugin:${flywayVersion}")
        classpath("org.springframework:spring-jdbc:${springVersion}")
    }

}

apply plugin: 'java'
apply plugin: 'idea'
apply plugin: 'org.springframework.boot'
apply plugin: 'project-report'
apply plugin: 'org.flywaydb.flyway'

flyway {
    url = 'jdbc:mysql://localhost/upshift?serverTimezone=UTC'
    user = 'root'
    password = 'root'
    locations = ['db.migration']
}

version = '0.0.1-SNAPSHOT'
sourceCompatibility = 1.8

repositories {
    mavenCentral()
}

dependencies {
    compile('org.springframework.boot:spring-boot-starter-data-jpa')
    compile("org.flywaydb:flyway-core:${flywayVersion}")
    compile('org.springframework.boot:spring-boot-starter-web')
    compile('org.springframework.boot:spring-boot-starter-security')
    runtime('mysql:mysql-connector-java')
    testCompile('org.springframework.security:spring-security-test')
    testCompile('org.springframework.boot:spring-boot-starter-test')
}