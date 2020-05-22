tasks.register("incrementVersion") {
    doFirst {
        def ver = version
        println ver
        String lastNumber = ver.substring(ver.lastIndexOf('.') + 1)
        int increment = lastNumber.toInteger() + 1
        println increment

        String firstNumber = ver.substring(0, ver.lastIndexOf("."))
        println firstNumber
        String result = buildFile.getText().replaceFirst("version='$version'","version='" + firstNumber + "." + increment + "'")
        buildFile.setText(result)
    }
}

jar.dependsOn incrementVersion
bootJar.dependsOn incrementVersion

bootJar {
    doFirst {
        manifest {
            attributes(
                    'Main-Class': 'com.example.appinfo.AppinfoApplication',
                    'Implementation-Title': 'Application Info project',
                    'Implementation-Version': "${version}"
            )
        }
    }
}