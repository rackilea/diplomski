if ( project.file("build.gradle").exists() ) {
    project.gradle.startParameter.taskNames.each { taskName -> 
        if ( taskName == "assembleDebug" || taskName == "assembleRelease" || taskName == "clean" ) {
          if ( project.hasProperty( "buildType" ) ) {
            //throw new GradleException( "cannot configure multiple build tasks" )
          }
          project.ext.buildType = taskName - "assemble"
       }
    }
  }