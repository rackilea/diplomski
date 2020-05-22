sourceSets {
    main {
        java {
            srcDirs = ["src/main/java", "${protobuf.generatedFilesBaseDir}/main/java"]
        }
    }
}