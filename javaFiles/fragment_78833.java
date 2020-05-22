val deployKey = TaskKey[Unit](
  "deploy",
  "Deploys the project in the `deploy` subdirectory."
)

val deployTask = deployKey <<= (artifactPath in (Compile, packageBin), dependencyClasspath in Compile) map {
  (artifact, classpath) =>
  val deploydir = new File("deploy")
  val libzdir = new File("deploy%slib".format(File.separator))

  // clean old subdirectory
  deploydir.delete()

  // create subdirectory structure
  deploydir.mkdir()
  libzdir.mkdir()

  // copy deps and artifacts
  val fullcp = classpath.map(_.data) :+ artifact
  def lastName(file: File) = if (file.isFile) file.getName else file.getParentFile.getParentFile.getParentFile.getName
  for (file <- fullcp) {
    println("Copying: " + file + "; lastName: " + lastName(file))
    if (file.isFile) IO.copyFile(file, (libzdir / lastName(file)).asFile);
    else IO.copyDirectory(file, (libzdir / lastName(file)))
  }
} dependsOn (packageBin in Compile)