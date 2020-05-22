apply plugin: 'android'

android {
    compileSdkVersion 19
    buildToolsVersion "19.1.0"

    applicationVariants.all { variant ->
        variant.javaCompile.dependsOn('GetJarUsingCompanyPrivateProtocol')
    }
}

task GetJarUsingCompanyPrivateProtocol {
    // This command will retrieve the jar
    // into folder "local/path/of/company/private/jar"
    commandLine 'get_jar_command'
}

dependencies {
    compile files('local/path/of/company/private/jar')
}