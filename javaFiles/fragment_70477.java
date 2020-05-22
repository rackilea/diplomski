public class DecryptWorker extends SwingWorker {

    private File[] files;

    public DecryptWorker(File[] files) {
        this.files = files;
    }

    @Override
    protected Object doInBackground() throws Exception {
        if(files[0] != null)    {
            ...
            for (int j = 0; j < files.length; j++) {
                            // SDencryptFiles() has System.out.println()'s in it, but
                    // no System.out's show in the JScrollPane until after 
                    // SDencryptFiles completes  I want then to appear as they
                    // are executed
                    SDencryptFiles(String, String, int);
            }
        }
        return null;
    }

}