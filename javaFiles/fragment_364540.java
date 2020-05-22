repositories {
    mavenCentral() // or whatever repo is right
}

configurations {
    jboss
}

dependencies {
    jboss "org.jboss.as:jboss-as-dist:7.1.1.Final@zip"
}

task resolveJBoss(type: Copy) {
    destinationDir = file("jboss")
    from { zipTree(configurations.jboss.singleFile) }
}