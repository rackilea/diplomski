plugins {
    id 'java'
}

repositories {
    mavenCentral()
}

dependencies {
    compile 'org.projectlombok:lombok:1.16.18'
    compile 'com.google.inject:guice:4.1.0'
    compile 'com.google.inject.extensions:guice-servlet:4.1.0'
    compile 'com.fasterxml.jackson.jaxrs:jackson-jaxrs-json-provider:2.9.3'
    compile 'org.eclipse.jetty:jetty-server:9.4.8.v20171121'
    compile 'org.eclipse.jetty:jetty-servlet:9.4.8.v20171121'
    compile 'org.glassfish.jersey.containers:jersey-container-jetty-servlet:2.26'
    compile 'org.glassfish.jersey.media:jersey-media-sse:2.26'
    compile 'org.glassfish.jersey.inject:jersey-hk2:2.26'
}