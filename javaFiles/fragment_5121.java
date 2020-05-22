int i = 0;
String classpathVar = configurations.compile.collect { " libs/" + (i++==0?String.format("%0\$-50s", it.getName()):String.format("%0\$-62s", it.getName()))   }.join(" ");
jar{
    manifest {
        attributes("Implementation-Title": "SIRIUS Workflow Executor",
                "Implementation-Version": version,
                "Class-Path": classpathVar )
    }
}