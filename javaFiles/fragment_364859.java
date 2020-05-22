repositories {
       flatDir {
           dirs 'libs'
       }
    }

    dependencies {
       compile files('libs/the_local_file.jar')
   }