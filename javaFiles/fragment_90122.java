task myCustomAnnotationProcessorTask(type: JavaCompile, group: 'build') {
    source = sourceSets.main.java
    classpath = sourceSets.main.compileClasspath
    options.compilerArgs = ['-proc:only',
                            '-processor', 'jacore.processors.Processor']
}
compileJava.dependsOn myCustomAnnotationProcessorTask