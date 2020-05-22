shadowJar {
    destinationDir = "/Users/User/Builds/${rootProject.name}/${project.name}"
}

task runApp(type: JavaExec) {
    main = "your.main.Class
    classpath = shadowJar.archiveFile // use archivePath before Gradle 5.1
}