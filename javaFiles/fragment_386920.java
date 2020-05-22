class HdfsClassLoaderclassLoader(classLoader: ClassLoader) extends URLClassLoader(Array.ofDim[URL](0), classLoader) {

    def addJarToClasspath(jarName: String) {
        synchronized {
            var conf = new Configuration
            val fileSystem = FileSystem.get(conf)
            val path = new Path(jarName);
            if (!fileSystem.exists(path)) {
                println("File does not exists")
            }
            val uriPath = path.toUri()
            val urlPath = uriPath.toURL()
            println(urlPath.getFile)
            addURL(urlPath)
        }
    }
}