class CCLoader extends ClassLoader {
    private Map<String, byte[]> classes = new HashMap<String, byte[]>();

    public CCLoader(InputStream in) {
        super(CCLoader.class.getClassLoader());
        try {
            JarInputStream jis = new JarInputStream(in);
            JarEntry je = null;
            String entryName = null;
            while ((je = jis.getNextJarEntry()) != null) {
                entryName = je.getName();
                if (je.getName().endsWith(".class")) {
                    byte[] classBytes = readClass(jis);
                    String canonicalName = entryName.replaceAll("/", ".").replaceAll(".class", "");
                    classes.put(canonicalName, classBytes);
                }
            }
            jis.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private byte[] readClass(InputStream stream) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        while(true){
            int qwe = stream.read();
            if(qwe == -1) break;
            baos.write(qwe);
        }
        return baos.toByteArray();
    }

    public Class loadClass(String name) throws ClassNotFoundException {
        try {
            return this.getParent().loadClass(name);
        } catch (ClassNotFoundException e) {
            return findClass(name);
        }
    }

    public Class findClass(String name) throws ClassNotFoundException {
        byte[] classBytes = classes.get(name);
        return defineClass(name, classBytes, 0, classBytes.length);
    }

}