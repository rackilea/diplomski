ClassLoader bootstrapClassLoader = ClassLoader.getSystemClassLoader().getParent();
List urls = new ArrayList();
urls.add(new File("yourJarOfXstreamBeanClasses.jar").toURL());
ClassLoader xstreamClassLoader = new URLClassLoader(urls.toArray(new URL[0]), bootstrapClassLoader);
XStream xstream = new XStream();
xstream.setClassLoader(xstreamClassLoader);