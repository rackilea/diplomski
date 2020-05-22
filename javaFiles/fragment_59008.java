val dirname: String = "/path"

  val files = new File(dirname)

  files.listFiles().filter( !_.isDirectory).map{
    file => process the file 
  }