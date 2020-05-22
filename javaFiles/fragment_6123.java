apply plugin: "java"

task testJar(type: Jar) {
    classifier = "tests"
    from sourceSets.test.output
    exclude "**/*Test.class"
}

artifacts {
    testRuntime testJar
}