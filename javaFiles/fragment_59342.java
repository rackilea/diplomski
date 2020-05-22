android.buildTypes.all{ theBuildType ->
tasks.whenTaskAdded{ theTask ->
    if(theTask.name == "generateFlavorWithoutEncryptionr${theBuildType.name.capitalize()}Sources"){
        theTask.dependsOn "copyNoEncryption"
    }
    else if(theTask.name == "generateFlavourWithEncryption${theBuildType.name.capitalize()}Sources"){
        theTask.dependsOn "copyEncryption"
    }
}
}