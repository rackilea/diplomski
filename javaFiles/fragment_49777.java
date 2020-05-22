task deleteJavaDebugLogs << {
    description "This function will delete all SDK DEBUG log level from the project, be careful with it!"
    FileTree  javaFiles = fileTree('src/main/java/com/"your-name"') {
        include '**/*.java'
    }
    String regex = "Logger.log[^,]+[^L]+(.*)Logger.SDK_DEBUG[^;];"
    javaFiles.each { File javaFile ->
        println "Start replacing regex on $javaFile.name"
        String content = javaFile.getText()
        content = content.replaceAll(regex, "")
        javaFile.setText(content)
    }
}