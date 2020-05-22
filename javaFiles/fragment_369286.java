subprojects {
    apply plugin: 'idea'
    // Due to Gradle 4.x changes (separate output directories per JVM language)
    // Idea developers refuse to reuse Gradle classpath and use own 'out/' directory.
    // Revert to old behavior to allow Spring Devtool to work with using fast Idea compiler.
    // https://youtrack.jetbrains.com/issue/IDEA-175172
    // Alternatively use native Gradle builds or bootRun.addResources = true
    // To use this feature push Ctrl+Shift+F9 to recompile!
    // Be aware that Idea put resources into classes/ directory!!
    idea.module.inheritOutputDirs = false
    idea.module.outputDir = sourceSets.main.output.classesDir
    idea.module.testOutputDir = sourceSets.test.output.classesDir
}