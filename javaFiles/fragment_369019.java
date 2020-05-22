repositories {
    mavenCentral()
}

apply plugin: 'java'
apply plugin: 'eclipse'
apply plugin: 'org.springframework.boot'

dependencies {
    implementation platform('org.springframework.boot:spring-boot-dependencies:2.0.0.RELEASE')

    implementation group: 'org.springframework.boot', name: 'spring-boot-starter-web', version: '2.0.0.RELEASE'
    implementation group: 'org.springframework.boot', name: 'spring-boot-starter-tomcat', version: '2.0.0.RELEASE'

    implementation group: 'org.springframework.boot', name: 'spring-boot-gradle-plugin', version: '2.0.0.RELEASE'
}