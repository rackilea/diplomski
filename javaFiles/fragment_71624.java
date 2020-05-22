sourceSets {
    integrationTest {
        compileClasspath += main.output
        runtimeClasspath += main.output
    }
    serviceTest {
        compileClasspath += main.output
        runtimeClasspath += main.output
    }
}

configurations {
    integrationTestCompile.extendsFrom testCompile
    integrationTestRuntime.extendsFrom testRuntime

    serviceTestCompile.extendsFrom testCompile
    serviceTestRuntime.extendsFrom testRuntime
}