[...]
jar {
    dependsOn 'clean'
    dependsOn 'test'
    tasks.findByName('test').mustRunAfter 'clean'
    [...]
}
[...]