buildscript {
repositories {
    mavenCentral()
}
dependencies {
    classpath("org.springframework.boot:spring-boot-gradle-plugin:1.4.1.RELEASE")
}
}

apply plugin: 'java'
apply plugin: 'idea'
apply plugin: 'spring-boot'

jar {
    baseName = 'gs-serving-web-content'
    version =  '0.1.0'
}

repositories {
    mavenCentral()
}

sourceCompatibility = 1.8
targetCompatibility = 1.8

dependencies {
    compile("org.springframework.boot:spring-boot-starter-thymeleaf")
    compile("org.springframework.boot:spring-boot-devtools")
    compile("org.hibernate.ogm:hibernate-ogm-bom:5.0.2.Final")
    compile group: 'org.hibernate.ogm', name: 'hibernate-ogm-infinispan', version: '5.0.2.Final'
    compile group: 'org.jboss.spec.javax.transaction', name: 'jboss-transaction-api_1.2_spec', version: '1.0.0.Final'
    compile group: 'org.hibernate.javax.persistence', name: 'hibernate-jpa-2.1-api', version: '1.0.0.Final'
    compile group: 'org.jboss.narayana.jta', name: 'narayana-jta', version: '5.3.5.Final'
    compile group: 'org.jboss', name: 'jboss-transaction-spi', version: '7.5.0.Final'
    compile group: 'javax.transaction', name: 'jta', version: '1.1'
    compile group: 'org.hibernate.common', name: 'hibernate-commons-annotations', version: '5.0.1.Final'

    testCompile("junit:junit")
}