android {
    buildTypes {
        debug {
            buildConfigField "int", "A_INT", "1"
            buildConfigField "String", "A_STRING", "\"string_1\"" // <---note the escape
        }

        release {
            buildConfigField "int", "A_INT", "2"
            buildConfigField "String", "A_STRING", "\"string_2\""
        }
    }
}