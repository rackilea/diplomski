android {
    defaultConfig {
        ...
    }

    buildTypes {
        ...
    }

    lintOptions {
        // Returns whether lint should be quiet (for example, not write informational messages such as paths to report files written)
        quiet true

        // Whether lint should set the exit code of the process if errors are found
        abortOnError false

        // Returns whether lint will only check for errors (ignoring warnings)
        ignoreWarnings true

        // Returns whether lint should check for fatal errors during release builds. Default is true.
        // If issues with severity "fatal" are found, the release build is aborted.
        checkReleaseBuilds false
    }
}