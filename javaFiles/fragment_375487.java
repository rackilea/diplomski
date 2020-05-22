configurations {
    def conf = 'vaadin-client'
    def sources = project.sourceSets.main
    def testSources = project.sourceSets.test

    if (!project.configurations.hasProperty(conf)) {
        project.configurations.create(conf)

        sources.compileClasspath += project.configurations[conf]
        testSources.compileClasspath += project.configurations[conf]
        testSources.runtimeClasspath += project.configurations[conf]

        project.configurations[conf].exclude group: 'org.eclipse.jetty' 
    }
}