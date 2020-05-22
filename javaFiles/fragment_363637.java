plugins {
    id 'org.springframework.boot' version '2.1.5.RELEASE'
}

jar {
    enabled = false
    archiveClassifier = 'jvm8'
}

bootJar {
    launchScript()
    archiveClassifier = 'jvm8'
    mainClassName = 'plugin.PluginKt'
}

jar.dependsOn(bootJar)