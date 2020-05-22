apply plugin: "java"

version = '0.1'
configurations {
    // let configurations that extend compile all the compile classpath entries
    compile.transitive = true
    // define a configuration
    one {
        description = 'compile configuration one\'s classpath'
        extendsFrom compile
    }
    // create another configuration
    two {
        description = 'compile configuration two\'s classpath'
        extendsFrom compile
    }
}

// let gradle know you want a jar from configuration named `one`
task('oneJar', type: Jar) {
    // define what configuration our jar contains
    from configurations.one
    // set the name so we know which jar is which configuration
    baseName = "$project.name-$configurations.one.name"
}

// let gradle know you want a jar from configuration named `two`
task('twoJar', type: Jar) {
    // define what configuration our jar contains
    from configurations.two
    // set the name so we know which jar is which configuration
    baseName = "$project.name-$configurations.two.name"
}

// make gradle build our other configuration jars anytime it runs the jar task
jar.dependsOn oneJar, twoJar

// boilerplate repository to look for dependencies
repositories {
    jcenter()
}

// here we can define configuration specific dependencies
dependencies {
    // will only appear in the "${project.name}-${project.version}.jar" file
    compile "com.google.code.gson:gson:2.4"
    // will only appear in the "${project.name}-one-${project.version}.jar" file
    one "com.google.code.gson:gson:2.6.1"
    // will only appear in the "${project.name}-two-${project.version}.jar" file
    two "com.google.code.gson:gson:2.7"
}