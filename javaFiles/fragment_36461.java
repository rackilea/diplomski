android {
    ...
    buildTypes {
        debug {
            buildConfigField "boolean", "TYPE", "true"
        }
        release {
            buildConfigField "boolean", "TYPE", "false"
        }
        ...
    }    
}