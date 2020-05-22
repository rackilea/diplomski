static {
    try {
        System.loadLibrary(RXTXSERIAL);
        System.loadLibrary(RXTXPARALLEL);
    } catch (UnsatisfiedLinkError exc) {
        initLibStructure();
    }
}


private static void initLibStructure() {

    try {
        //runntime Path
        String runPath = new File(".").getCanonicalPath();

        //create folder
        File dir = new File(runPath + "/" + LIB);
        dir.mkdir();

        //get environment variables and add the path of the 'lib' folder
        String currentLibPath = System.getProperty("java.library.path");
        System.setProperty("java.library.path",
                currentLibPath + ";" + dir.getAbsolutePath());

        Field fieldSysPath = ClassLoader.class
                .getDeclaredField("sys_paths");
        fieldSysPath.setAccessible(true);
        fieldSysPath.set(null, null);

        loadLib(runPath, RXTXPARALLEL);
        loadLib(runPath, RXTXSERIAL);

    } catch (Exception e) {
        e.printStackTrace();
    }
}

private static void loadLib(String path, String name) {
    name = name + ".dll";
    try {
        InputStream in = ResourceLoader.load(LIB + name);
        File fileOut = new File(path + "/" + LIB + name);

        OutputStream out = FileUtils.openOutputStream(fileOut);
        IOUtils.copy(in, out);
        in.close();
        out.close();
        System.load(fileOut.getAbsolutePath());
    } catch (Exception e) {
        e.printStackTrace();
    }
}