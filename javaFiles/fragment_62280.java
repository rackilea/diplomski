public class BackgroundWorker extends SwingWorker<Object, String> {

    private JTextArea textArea;
    private File sourceDir;
    private File destDir;

    public BackgroundWorker(JTextArea textArea, File sourceDir, File destDir) {

        this.textArea = textArea;
        this.sourceDir = sourceDir;
        this.destDir = destDirl

    }

    @Override
    protected Object doInBackground() throws Exception {

        if (sourceDir.isDirectory()) {

            // if directory not exists, create it
            if (!destDir.exists()) {
                destDir.mkdir();
                publish("Folder " + sourceDir.getName() + " was created");
            }

            // list all the directory contents
            String files[] = sourceDir.list();

            for (String file : files) {
                // construct the src and dest file structure
                File srcFile = new File(sourceDir, file);
                File destFile = new File(destDir, file);
                // recursive copy
                copyFolder(srcFile, destFile);
            }

        } else {
            try {
                copyFile(sourceDir, destDir);
            } catch (Exception e) {
            }
        }

        return null;

    }

    public void copyFolder(File src, File dest) throws IOException {

        if (src.isDirectory()) {

            // if directory not exists, create it
            if (!dest.exists()) {

                publish("Folder " + src.getName() + " was created");
            }

            // list all the directory contents
            String files[] = src.list();

            for (String file : files) {
                // construct the src and dest file structure
                File srcFile = new File(src, file);
                File destFile = new File(dest, file);
                // recursive copy
                copyFolder(srcFile, destFile);
            }

        } else {
            try {
                copyFile(src, dest);
            } catch (Exception e) {
            }
        }
    }

    public void copyFile(File src, File dest) throws Exception {
        // if file, then copy it
        // Use bytes stream to support all file types
        InputStream in = new FileInputStream(src);
        OutputStream out = new FileOutputStream(dest);

        byte[] buffer = new byte[1024];

        int length;
        // copy the file content in bytes
        while ((length = in.read(buffer)) > 0) {
            out.write(buffer, 0, length);
        }

        in.close();
        out.close();
        publish("File copied " + src.getName());

    }

    @Override
    protected void process(List<String> chunks) {

        for (String msg : chunks) {

            textArea.append(msg + "\n");

        }

        textArea.setCaretPosition(textArea.getText().length() - 1);

    }
}