compileModuleInfoJava {
    sourceCompatibility = 9    
    targetCompatibility = 9

inputs.property("moduleName", moduleName)

doFirst {
    classpath += sourceSets.main.compileClasspath

    options.compilerArgs = [
        '--module-path', classpath.asPath,
        '--add-modules', 'ALL-SYSTEM,org.apache.logging.log4j',
        '-d', sourceSets.main.output.classesDirs.asPath
    ]
}
}