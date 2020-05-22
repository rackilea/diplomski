tasks.register('common-jar', Jar) {
    description 'build common jar'
    manifest {
        attributes 'Build': project.version
    }
    baseName project.name + '-common'
    from {
        project.buildDir.toPath().resolve('classes.common').toFile()
    }
    dependsOn 'compile-common'
}

tasks.register('project-jar', Jar) {
    description 'build project jar'
    manifest {
        attributes 'Build': project.version
    }
    baseName project.name
    from {
        sourceSets.main.output
    }
    dependsOn 'compileScala'
}