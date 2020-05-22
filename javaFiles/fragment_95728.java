public class MyPluginTask extends DefaultTask {

    @TaskAction
    public void action() throws Exception {

        // sourceDir can be a string or a File
        File sourceDir = new File(getProject().getProjectDir(), "src/main/html");
        // or:
        //String sourceDir = "src/main/html";

        ConfigurableFileTree cft = getProject().fileTree(sourceDir);
        cft.include("**/*.html");

        // Make sure we have some input. If not, throw an exception.
        if (cft.isEmpty()) {
            // Nothing to process. Input settings are probably bad. Warn user.
            throw new Exception("Error: No processable files found in sourceDir: " +
                    sourceDir.getPath() );
        }

        Iterator<File> it = cft.iterator();
        while (it.hasNext()){
            File f = it.next();
            System.out.println("File: "+f.getPath()"
        }
    }

}