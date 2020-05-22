apply plugin: 'java'

project.ext.sm2Resources = project.file("../sm2/src/main/resources")

sourceSets {
    main {
        resources {
            srcDir(sm2Resources)
        }
    }
}

jar {
  eachFile { f ->
      if(new File(sm2Resources, f.file.name).exists()) {
        f.path = "sm2/$f.name"
      }
  }
}