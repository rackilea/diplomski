public static void startSecondJVM() throws Exception {
    String separator = System.getProperty("file.separator");
    String classpath = System.getProperty("java.class.path");
    String path = System.getProperty("java.home")
            + separator + "bin" + separator + "java";
    ProcessBuilder processBuilder = 
            new ProcessBuilder(path, "-Xmx1024m", "-cp",
            classpath, 
            Main.class.getName());
    Process process = processBuilder.start();
}