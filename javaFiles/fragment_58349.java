task nativeLibsToJar(type: Zip, description: "create a jar archive of the native libs") {
    destinationDir file("$projectDir/libs")
    baseName "Native_Libs"
    extension "jar"
    from fileTree(dir: "libs", include: "**/*.so")
    into "lib"
}

tasks.withType(JavaCompile) {
    compileTask -> compileTask.dependsOn(nativeLibsToJar)
}

sourceSets {
    main {
        jniLibs.srcDirs = ['libs']
    }
}