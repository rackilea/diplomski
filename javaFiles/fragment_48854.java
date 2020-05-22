configurations {
    something { transitive = false }
}
dependencies {
    something 'org.company:something:1.0'
    something 'org.company:something-else:1.0'
    compile files(tasks['dummyTask'])
    compile 'org.foo:some-normal-dep:1.1'
}
task copySomething(type:Copy) {
    from configurations.something
    into "$buildDir/something"
    rename '(.+)-.+?\\.jar', '$1.jar'
}
task dummyTask {
    dependsOn copySomething
    inputs.dir "$buildDir/something"
    outputs.files fileTree("$buildDir/something")
}