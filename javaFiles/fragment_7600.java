android {
    signingConfigs {
        release {
            keyAlias 'XXXXX'
            keyPassword 'XXXXX'
            storeFile file('../keystore/XXXXX') // Add in project_directory/keystore/ don't worry about extention
            storePassword 'XXXXX'
        }

buildTypes {
        release {
            signingConfig signingConfigs.release 
        }
        debug {}
    }
   ...
    }