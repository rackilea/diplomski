task packageImplementation {
dependsOn cleanImplementationClasses

doLast {
    def paths = project.configurations.runtime.asPath
    paths.split(':').each { dependencyJar ->
        println "unpacking" + dependencyJar

        ant.unzip(src: dependencyJar,
                dest: "build/classes/main/private/",
                overwrite: "true")
        }
    }
}