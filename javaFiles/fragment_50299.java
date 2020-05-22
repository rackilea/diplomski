...
docker {
    name "${project.group}/${jar.baseName}"
    files jar.archivePath
    buildArgs(['JAR_FILE': "${jar.archiveName}"])
}

bootJar {
    baseName = 'gs-spring-boot-docker'
    version =  '0.1.0'
}
...