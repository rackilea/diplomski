allprojects {
    repositories {
    //start here
    configurations.all {
 resolutionStrategy.eachDependency { DependencyResolveDetails details ->
   def requested = details.requested
       if (requested.group == 'com.google.android.gms') {
          details.useVersion '12.0.1'
       }
       if (requested.group == 'com.google.firebase') {
          details.useVersion '12.0.1'
         }
       }
     }
    //end
     jcenter()
       maven {
         url "https://maven.google.com"
       }
     }
 }