apply plugin: 'distribution'

distributions {
    main {
        baseName = "${project.name}"
        contents {
            into('/conf'){
                from('src/main/resources')
                exclude("application.yml")
            }
            into('/lib'){
                from('build/libs')
            }
            into('/bin'){
                from('../bin')
            }
        }
    }
}

processResources.enabled = false

distTar {
    dependsOn bootJar
}

tasks.withType(Tar) {
    compression = Compression.GZIP
    extension = "tar.gz"
}

configurations {
    customArch
}

artifacts {
    customArch file(distTar.archivePath)
}