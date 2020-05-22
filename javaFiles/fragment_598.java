apply plugin: 'war'

repositories {
   mavenCentral()
}

dependencies {
    providedCompile 'org.apache.tomcat:tomcat-catalina:7.0.47'
}