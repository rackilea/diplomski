gradle.taskGraph.whenReady {
    graph ->
        if (project.hasProperty("httpPort")) {
            gretty.httpPort = httpPort as int
        }
}