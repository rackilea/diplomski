task sourcesJar(type: Jar) {
    from sourceSets.main.allJava
    archiveClassifier.set("sources")
}
task javadocJar(type: Jar, dependsOn: javadoc) {
     archiveClassifier.set("javadoc")
    from javadoc.destinationDir
}

publishing {
      publications {
          mavenAar(MavenPublication) {
                from components.java
                afterEvaluate {
                    artifact javadocJar
                    artifact sourcesJar
                }
          }
     }
}