tasks.register("buildClasspath") {
    val main by sourceSets
    doFirst {
        println(main.compileClasspath.asPath)
    }
}