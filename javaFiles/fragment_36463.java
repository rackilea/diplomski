productFlavors {
    // Define separate dev and prod product flavors.
    dev {
        buildConfigField "boolean", "IS_DEV", "true"
    }

    prod {
        buildConfigField "boolean", "IS_DEV", "false"
    }
}