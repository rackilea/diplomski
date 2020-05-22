configurations {
      provided
      // Make compile extend from our provided configuration so that things added to bundled end up on the compile classpath
      compile.extendsFrom(provided)
   }

   dependencies {
      provided group: 'org.spigotmc', name: 'spigot', version: '1.8-R0.1-RELEASE'
   }

   jar {
       // Include all of the jars from the bundled configuration in our jar
       from configurations.provided.asFileTree.files.collect { zipTree(it) }
   }