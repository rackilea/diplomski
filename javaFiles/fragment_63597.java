bundle {
    density {
        // Different APKs are generated for devices with different screen densities; true by default.
        enableSplit true
    }
    abi {
        // Different APKs are generated for devices with different CPU architectures; true by default.
        enableSplit true
    }
    language {
        // This is disabled so that the App Bundle does NOT split the APK for each language.
        // We're gonna use the same APK for all languages.
        enableSplit false
    }
}