private List<Class<?>> loadClasses(String pathToJar){

   ArrayList<Class<?>> classes = new ArrayList<Class<?>>();
            JarFile jarFile = null;
            try {
                jarFile = new JarFile(pathToJar);
                Enumeration<JarEntry> e = jarFile.entries();
                URL[] urls = { new URL("jar:file:" + pathToJar+"!/") };
                URLClassLoader cl = URLClassLoader.newInstance(urls);
                while (e.hasMoreElements()) {
                 JarEntry je = e.nextElement();

                 if(je.isDirectory() || !je.getName().endsWith(".class")){
                   continue;
                 }
                 String className = je.getName().substring(0,je.getName().length()-String.valueOf(".class").length());
                 className = className.replace('/', '.');
                 Class<?> clazz = cl.loadClass(className);
                 classes.add(clazz);
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            }finally {
                try {
                    jarFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
    return classes.isEmpty() ? null : classes;
}