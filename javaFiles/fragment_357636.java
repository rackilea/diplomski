apply plugin: "java"

sourceSets {
    // Note that just declaring this sourceset creates two configurations.
    intTest {
        java {
            compileClasspath += main.output
            runtimeClasspath += main.output
        }
    }
}

configurations {
    intTestCompile.extendsFrom testCompile
    intTestRuntime.extendsFrom testRuntime
}

task intTest(type:Test){
    description = "Run integration tests (located in src/intTest/...)."
    testClassesDir = project.sourceSets.intTest.output.classesDir
    classpath = project.sourceSets.intTest.runtimeClasspath
}