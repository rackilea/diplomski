// Make sure the source files are compiled.
sourceSets {
    main {
        java {
            srcDir 'APP-INF/src'
        }
    }
}

ear {
    baseName 'PRJ'
    libDirName 'APP-INF/lib'

    into("META-INF") {
        from("META-INF") {
            exclude 'application.xml'
        }
    }
    into("WEB_MAIN") {
        from("WEB_MAIN")
    }

    deploymentDescriptor {
        webModule 'WEB_MAIN', '/'
        applicationName = "PRJ"
    }

    // Exclude the compiled classes from the root of the EAR.
    // Replace "com/javathinker/so/" with your package name.
    eachFile { copyDetails ->
        if (copyDetails.path.startsWith('com/javathinker/so/')) {
            copyDetails.exclude()
        }
    }

    // Copy the compiled classes to the desired directory.
    into('APP-INF/classes') {
        from(compileJava.outputs)
    }

    // Remove empty directories to keep the EAR clean.
    includeEmptyDirs false
}