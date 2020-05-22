configurations {
    all*.exclude module: 'geronimo-javamail_1.4_spec'
}

dependencies {
    testCompile group: 'junit', name: 'junit', version: '4.12'
    compile("org.springframework.boot:spring-boot-starter-web")  
    compile("org.springframework.boot:spring-boot-starter-batch")
    //compile("org.springframework.boot:spring-boot-devtools")
    compile('org.apache.commons:commons-lang3:3.5')
    compile group: 'org.apache.cxf', name: 'cxf-spring-boot-starter-jaxws', version: '3.1.10'
    compile group: 'org.apache.cxf', name: 'cxf-rt-ws-security', version: '3.1.10'
    testCompile('org.springframework.boot:spring-boot-starter-test')
}