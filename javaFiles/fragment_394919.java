android {
    externalNativeBuild {
        cmake {
            path "CMakeLists.txt"
        }
    }
    defaultConfig {
        externalNativeBuild {
            cmake {
                abiFilters "x86"
            }
        }
    }
}