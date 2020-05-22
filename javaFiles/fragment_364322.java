public static void selfUpdate() {

    try {
        String separator = System.getProperty("file.separator");
        String classpath = System.getProperty("java.class.path");
        String rootPath = System.getProperty("user.dir");

        String path = null;

        File parentFolder = null;
        File originalClientFolder = new File(rootPath);
        parentFolder = originalClientFolder.getParentFile();

        File secondClientFolder = new File(parentFolder.getAbsolutePath() + separator + "runLAST");
        FileUtils.copyDirectory(originalClientFolder, secondClientFolder);

        // ADDED: --------------------------------------------------------
        String origialClientFolderName = originalClientFolder.getName();
        classpath = classpath.replace(origialClientFolderName, "runLAST");
        // ---------------------------------------------------------------

        path = secondClientFolder.getAbsolutePath() + separator + "jre8" + separator + "bin" + separator + "java";

        ProcessBuilder processBuilder = new ProcessBuilder(path, "-cp", classpath, SelfUpdater.class.getName(), downloadURL, rootPath);            
        processBuilder.directory(secondClientFolder);
        processBuilder.start();

        System.exit(0);

    } catch (Exception ex) {

    }
}