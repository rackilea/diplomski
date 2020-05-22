jar {
  manifest { 
    attributes "Main-Class": "foo.Main"
  }
  from {
    configurations.compile.collect {
      it.isDirectory() ? it : zipTree(it)
    }
    configurations.runtime.collect {
      it.isDirectory() ? it : zipTree(it)
    }
  }

  from('src/main/java') {
     include '**/*.css'
  }

}