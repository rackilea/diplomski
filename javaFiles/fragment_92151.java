jfx {
    // ... normal configuration ...

    // your secondary entry points, each will create a native executable (and one .cfg-file for each)
    secondaryLaunchers = [
        // second executable
        [
            appName: 'somethingDifferent'
            // will create the same executable, just with a different name (so this is demo-purpose only)
        ],
        // third executable
        [
            appName: 'somethingDifferent2',
            // specify your different entry-point
            mainClass: 'your.different.entrypoint.MainApp'
            // other possible entries: "jfxMainAppJarName", "jvmProperties", "jvmArgs", "userJvmArgs", "nativeReleaseVersion", "needShortcut", "needMenu", "vendor", "identifier"
        ]
    ]
}