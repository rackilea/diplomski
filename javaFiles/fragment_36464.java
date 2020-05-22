android {
    buildTypes {
        debug{
            resValue "string", "dev_name", "Alice"
        }

        release {
            resValue "string", "dev_name", "Bob"
        }
    }
}