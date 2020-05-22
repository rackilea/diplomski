configurations {
    paranamer
}

dependencies {
    paranamer 'com.thoughtworks.paranamer:paranamer-ant:2.8'
}

compileJava.doLast {
    ant.taskdef name: 'paranamer',
                classname: 'com.thoughtworks.paranamer.ant.ParanamerTask',
                classpath: configurations.paranamer.asPath
    ant.paranamer(classdir: destinationDir) {
        source.addToAntBuilder ant, 'fileset', FileCollection.AntType.FileSet
    }
}