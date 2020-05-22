SwingWorker<Boolean, String> worker = (new SwingWorker<Boolean, String>() {
    protected Boolean doInBackground() throws Exception {
        for (int i = 0; i < model.size(); i++) {
            File currentDir = new File(model.get(i));
            searchFiles(currentDir); // The recursive method
        }
        return true;
    }

    protected void process(List<String> chunks) {
        jpanel.someLabel.addFile(chunks.toString());
    }

    private void searchFiles(File fn) {
        if (fn.isDirectory()) {
            String[] subDir = fn.list();
            if (subDir != null) {
                for (String fn2 : subDir) {
                searchFiles(new File(fn, fn2));
            }
        }
        } else { // If fn isn't a directory, then it must be a file
            String absoluteFile = fn.getAbsoluteFile().toString();
            publish(absoluteFile);
        }
    }

});
worker.execute();