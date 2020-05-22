//remove the basicTypes as these are only place holder while the real implementation is somewhere else.
task removeBasicTypes {
    dependsOn compileJava
    doLast {
        println "Removing java files of all the basic types."
        //cleanup the generated java classes
        delete fileTree(dir: 'src/main/java/com/myCompany/myProject/basicTypes' , include: '**/*.java')
        //cleanup also the build folder that will be used to generate the jar file
        delete fileTree(dir: 'build/classes/java/main/com/myCompany/myProject/basicTypes' , include: '**/*.class')
    }
}

task generateAvro(type: com.commercehub.gradle.plugin.avro.GenerateAvroJavaTask) {
    source("$rootDir/basicTypes", "src/main/avro")
    outputDir = file("src/main/java")

    finalizedBy('removeBasicTypes')
}