buildTypes {
    debug {
        productFlavors.flavor1.buildConfigField "String", "app_name", "\"App 1 Debug\""
        productFlavors.flavor2.buildConfigField "String", "app_name", "\"App 2 Debug\""
    }
    release {
        productFlavors.flavor1.buildConfigField "String", "app_name", "\"App 1\""
        productFlavors.flavor2.buildConfigField "String", "app_name", "\"App 2\""
    }
}