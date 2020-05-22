@TaskAction
def task() {
   project.copy {
      from(project.fileTree(dir: srcDir).files) {
         include {
           it.file.name.contains('$$')
         }
      }
      into('somewhere')
      rename { name ->
         name.replace('$$', '$')
      }
   }
}