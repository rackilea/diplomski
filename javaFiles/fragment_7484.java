android.applicationVariants.all { variant ->
    variant.outputs.each { output ->
        // Redirect your apks to new defined location to outputDirPath
        def outputDirPath = new File("${project.rootDir.absolutePath}/apks/${variant.flavorName}/${variant.buildType.name}")
        variant.packageApplicationProvider.get().outputDirectory = outputDirPath

        def apkFileName = "${rootProject.name}_${android.defaultConfig.versionName}.apk"
        output.outputFileName = apkFileName // directly assign the new name back to outputFileName
    }
}