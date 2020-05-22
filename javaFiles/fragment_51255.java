plugins {
    id "io.spring.dependency-management" version "1.0.6.RELEASE"
    id "com.github.johnrengelman.shadow" version "4.0.2"    
}

apply plugin:"application"
apply plugin:"groovy"

version "0.1"
group "webapp"

repositories {
    mavenLocal()
    mavenCentral()
    maven { url "https://jcenter.bintray.com" }
}

dependencyManagement {
    imports {
        mavenBom 'io.micronaut:micronaut-bom:1.0.2'
    }
}

ext {
    gormVersion = '6.1.9.RELEASE'
    h2Version = '1.4.196'
    tomcatJdbcVersion = '8.5.28'
    springSecurityCryptoVersion='4.2.5.RELEASE'
}

dependencies {
    compile "io.micronaut.configuration:micronaut-jdbc-tomcat"
    compile "io.micronaut.configuration:micronaut-hibernate-validator"
    compile "io.micronaut.configuration:micronaut-hibernate-gorm"
    compile "org.grails:grails-datastore-gorm-hibernate5:$gormVersion"

    compile "io.micronaut:micronaut-http-client"
    compile "io.micronaut:micronaut-http-server-netty"
    compile "io.micronaut:micronaut-runtime-groovy"
    compile "io.micronaut:micronaut-validation"
    compile "javax.annotation:javax.annotation-api"
    compileOnly "io.micronaut:micronaut-inject-groovy"
    runtime "ch.qos.logback:logback-classic:1.2.3"
    runtime "com.h2database:h2"
    runtime "org.apache.tomcat:tomcat-jdbc"
    testCompile "io.micronaut:micronaut-inject-groovy"
    testCompile("org.spockframework:spock-core") {
        exclude group: "org.codehaus.groovy", module: "groovy-all"
    }

    runtime "org.hibernate:hibernate-ehcache:5.1.9.Final"
    runtime group: 'mysql', name: 'mysql-connector-java', version: '8.0.13'

}

shadowJar {
    mergeServiceFiles()
}

run.jvmArgs('-noverify', '-XX:TieredStopAtLevel=1')

mainClassName = "webapp.Application"
tasks.withType(GroovyCompile) {
    groovyOptions.forkOptions.jvmArgs.add('-Dgroovy.parameters=true')
}