// create a properties file add it to folder preprocessing
    task propertiesFile << {
        // 
        description 'Dynamically creates a properties file.'

        // needed for the first pass
        def folder = project.file('src/main/resources');
        if(!folder.exists()){
            folder.mkdirs()
        }

        //write it to a propertiess file
        def props = project.file('src/main/resources/test.properties')
        props.delete()
        props << 'write this to my file!!!!'

    }

    processResources.dependsOn propertiesFile