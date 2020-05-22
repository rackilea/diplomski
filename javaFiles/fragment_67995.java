sourceSets {
    testLocal {
        java.srcDir file('src/test/java')
        resources.srcDir file('src/test/resources')
    }
}

dependencies {
    // Dependencies for your production code here.
    compile 'some.library'

    // localTest dependencies, including dependencies required by production code.
    testLocalCompile 'some.library'
    testLocalCompile 'junit:junit:4.11'
    testLocalCompile 'com.google.android:android:4.1.1.4'
    testLocalCompile 'org.robolectric:robolectric:2.2'
}

task localTest(type: Test, dependsOn: assemble) {
    testClassesDir = sourceSets.testLocal.output.classesDir

    android.sourceSets.main.java.srcDirs.each { dir ->
        def buildDir = dir.getAbsolutePath().split('/')
        buildDir =  (buildDir[0..(buildDir.length - 4)] + ['build', 'classes', 'debug']).join('/')

        sourceSets.testLocal.compileClasspath += files(buildDir)
        sourceSets.testLocal.runtimeClasspath += files(buildDir)
    }

    classpath = sourceSets.testLocal.runtimeClasspath
}

check.dependsOn localTest