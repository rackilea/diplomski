javaCompileOptions {
    annotationProcessorOptions {
        arguments = ["room.schemaLocation":
                             "$projectDir/schemas".toString()]
    }
}