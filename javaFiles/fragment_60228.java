configurations {
    intellij
}

dependencies {
    intellij 'com.intellij:javac2:13'
}

compileJava {
    doLast() {
        project.ant.taskdef name: 'javac2', classname: 'com.intellij.ant.Javac2', classpath: project.configurations.intellij.asPath
        project.ant.javac2 srcdir: project.sourceSets.main.java.srcDirs.join(':'),
                includes: 'yourpackage/**/*.form',
                classpath: project.sourceSets.main.runtimeClasspath.asPath,
                destdir: project.sourceSets.main.output.classesDir,
                source: project.sourceCompatibility,
                target: project.targetCompatibility,
                includeAntRuntime: false,
                instrumentnotnull: project.ext.instrument
    }
}