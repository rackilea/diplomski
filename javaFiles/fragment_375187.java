public Class loadClass(String classname)  throws ClassNotFoundException {
    if (classname.equals("A")) {
        InputStream is = getResourceAsStream("A.class");
        byte[] bodge = new byte[8192];  // Should read until EOF
        try {
            int len = is.read(bodge);
            return defineClass("A", bodge, 0, len);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    return super.loadClass(classname, true);
}