configurations {
    testArtifacts.extendsFrom testRuntime
}
task testJar(type: Jar) {
    classifier "test"
    from sourceSets.test.output
}
artifacts {
    testArtifacts testJar
}