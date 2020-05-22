class IncrementalReverseTask extends DefaultTask {
     @InputDirectory
     def File inputDir

     @OutputDirectory
     def File outputDir

     @TaskAction
     void execute(IncrementalTaskInputs inputs) {
         inputs.outOfDate { change ->
             def targetFile = project.file("$outputDir/${change.file.name}")
             targetFile.text = change.file.text.reverse()
         }

         inputs.removed { change ->
             def targetFile = project.file("$outputDir/${change.file.name}")
             if (targetFile.exists()) {
                 targetFile.delete()
             }
         }
     }
 }