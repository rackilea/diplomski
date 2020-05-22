sourceSets {
    generated
}
sourceSets.generated.java.srcDirs = ['src/main/generated']
configurations {
    querydslapt
}
dependencies {
    // other deps ....
    compile "com.mysema.querydsl:querydsl-jpa:3.6.3"
    compile "com.mysema.querydsl:querydsl-apt:3.6.3:jpa"
}
task generateQueryDSL(type: JavaCompile, group: 'build', description: 'Generates the QueryDSL query types') {
    source = sourceSets.main.java
    classpath = configurations.compile + configurations.querydslapt
    options.compilerArgs = [
            "-proc:only",
            "-processor", "com.mysema.query.apt.jpa.JPAAnnotationProcessor"
    ]
    destinationDir = sourceSets.generated.java.srcDirs.iterator().next()
}

compileJava {
    dependsOn generateQueryDSL
    source generateQueryDSL.destinationDir
}

compileGeneratedJava {
    dependsOn generateQueryDSL
    classpath += sourceSets.main.runtimeClasspath
}