ClassLoader classLoader = this.getClass().getClassLoader();
if(classLoader instanceof URLClassLoader){
    URLClassLoader urlClassLoader = URLClassLoader.class.cast(classLoader);
    URL resourceUrl = urlClassLoader.findResource("file.name");

    if("file".equals(resourceUrl.getProtocol())){
        URI uri = resourceUrl.toURI();
        File file = new File(uri);
        decider.load(file);
    }
}