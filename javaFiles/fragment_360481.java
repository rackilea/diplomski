group 'nl.msegers.project.services.myservice'
version parent.version

jar {
    baseName = 'myservice'
    version =  parent.version
}

repositories {
    mavenCentral()
}