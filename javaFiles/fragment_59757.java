lazy val model =
  project.in(file("model"))
    // .settings(publishSettings:_*)
    .settings(librarySettings:_*)
    .settings(paranoidOptions:_*)
    .settings(otestFramework: _*)
    .settings(deps_tagging:_*)
    //-- .settings(deps_stream:_*)
    .settings(deps_database:_*)
    .settings(
      Seq(
        // This trick requires SBT 0.13.8
        manipulateBytecode in Compile := {
          val previous = (manipulateBytecode in Compile).value
          sbtRunner(  // javaRunner also works!
            mainClass = "javax.jdo.Enhancer",
            args =
              Seq(
                "-v",
                "-pu", "persistence-h2",
                "-d",  (classDirectory in Compile).value.absolutePath),
            classpath =
              (managedClasspath in Compile).value.files ++
                (unmanagedResourceDirectories in Compile).value :+
                (classDirectory in Compile).value,
            cwd = (classDirectory in Compile).value,
            javaHome = javaHome.value,
            envVars = (envVars in Compile).value
          )
          previous
        }
      ):_*)
    .dependsOn(util)