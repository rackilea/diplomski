public String[] getFiles() throws IOException {
   ArrayList<String> list = new ArrayList<String>();
   List<JarEntry> ents = new ArrayList<JarEntry>();
   Enumeration<JarEntry> e = null;

   URL jarp = getLocation();
   if (jarp != null) {
    jar = jarp.getProtocol().equalsIgnoreCase("jar") ? jarp : new URL("jar:" +                                                                                                                                                                                      jarp.toString() + "!/");
    JarFile jarf = null;
    try {
        jarf = AccessController.doPrivileged(
                new PrivilegedExceptionAction<JarFile>() {

                    @Override
                    public JarFile run() throws Exception {
                        JarURLConnection conn = (JarURLConnection) jar.openConnection();
                        conn.setUseCaches(false);
                        return conn.getJarFile();
                    }
                });
    } catch (PrivilegedActionException ex) {
        Logger.getLogger(LicenseLoader.class.getName()).log(Level.SEVERE, null, ex);
    }
    e = jarf.entries();
    while (e.hasMoreElements()) {
        JarEntry je = e.nextElement();
        if (!je.isDirectory()) {
            ents.add(je);
        }
    }
    for (JarEntry ent : ents) {
        if ((ent.getName().startsWith(pathName)) && (ent.getName().endsWith(".gif"))) {
            String name = ent.getName().replace(pathName, "");
            list.add(name);
        }
    }
 }
 return list.toArray(new String[list.size()]);
}