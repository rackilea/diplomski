task codeServer(dependsOn: "war") << {
    println("*----------------------------------------------------------------------------------------------*")
    println("   Ignore what this says below about going to http://localhost:9876/")
    println("   Instead, once the server below is up, in a separate command line, type:")
    println("       start $buildDir\\exploded\\Admin.html")
    println("*----------------------------------------------------------------------------------------------*")

    def gwtTempDir = "$buildDir/gwtTemp"
    (new File(gwtTempDir)).mkdirs()

    ant.java(classname: "com.google.gwt.dev.codeserver.CodeServer", failonerror: "true", fork: "true") {
        classpath {
            pathElement(location: "src/main/java")
            pathElement(location: "src/main/resources")
            pathElement(location: "$buildDir/classes/main")
            pathElement(path: configurations.compile.asPath)
        }
        jvmarg(value: "-Xmx512m")
        sysproperty(key: "java.util.logging.SimpleFormatter.format", value: System.getProperty("java.util.logging.SimpleFormatter.format"));
        arg(line: "-workDir " + gwtTempDir)
        arg(line: "-src " + "src/main/java")
        arg(value: "com.onlyinsight.oventio.Admin")
    }
}