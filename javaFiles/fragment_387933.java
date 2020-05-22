apply plugin: 'java'
apply plugin: 'idea'

repositories {
    jcenter()
    flatDir {
        dirs 'libs'
    }
}

dependencies {
    compile 'zzz:zzz-0.0.0'
    compile 'aaa:aaa-0.0.0'
    compile 'com.google.guava:guava:24.0-jre'
    compile group: 'javax.websocket', name: 'javax.websocket-api', version: '1.1'
}

task wrapper(type: Wrapper) {
    gradleVersion = '4.9'
    distributionUrl = "http://services.gradle.org/distributions/gradle-${gradleVersion}-bin.zip"
}