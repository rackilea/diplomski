task processRawFiles(type: ProcessRawFiles)

class ProcessRawFiles extends DefaultTask {
    @InputDirectory
    File inputDir = project.file('src/raw')

    @OutputDirectory
    File outputDir = project.file('build/processed')

    @TaskAction
    void execute(IncrementalTaskInputs inputs) {
        if (!inputs.incremental)
            project.delete(outputDir.listFiles())

        inputs.outOfDate { InputFileDetails change ->
            File saveTo = new File(outputDir, change.file.name)
            project.exec {
                commandLine 'script/process.sh', change.file.absolutePath, saveTo.absolutePath
            }
        }

        inputs.removed { InputFileDetails change ->
            File toDelete = new File(outputDir, change.file.name)
            if (toDelete.exists())
                toDelete.delete()
        }
    }
}