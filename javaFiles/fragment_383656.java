task deleteOldJar(type: Delete) {
    delete 'release/AndroidPlugin.jar'
}
task exportJar(type: Copy) {
    from('build/intermediates/bundles/release/')
    into('release/')
    include('classes.jar')
    rename('classes.jar', 'AndroidPlugin.jar')
}

exportJar.dependsOn(deleteOldJar, build)