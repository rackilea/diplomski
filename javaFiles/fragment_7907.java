task copyTestLibs(type: Copy) {
    into('libs-test')
    def javaProjects = subprojects.findAll { it.plugins.hasPlugin('java') }
    from javaProjects.collect {
        it.configurations.testCompile.copy().files {!(it instanceof ProjectDependency)}}.flatten().unique()
}