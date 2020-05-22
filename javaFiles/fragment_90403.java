if ( project.file("build.gradle").exists() ) {
    project.gradle.startParameter.taskNames.each { taskName -> 
        if (taskName.contains( "Debug" ) ) {
          project.ext.buildType = "Debug";
        } else if( taskName.contains( "Release" ) ) {
          project.ext.buildType = "Release";
        }    
    }
  }