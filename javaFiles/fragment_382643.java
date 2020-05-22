task gen (type: Jar) {
    description "Generates JAR without version number."
    archiveName = filename + ".jar"
    manifest {attributes 'Main-Class': mainFile}
    with jar
}