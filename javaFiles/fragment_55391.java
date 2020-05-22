new SwingWorker<String,Void>() {
    @Override
    protected String doInBackground() throws Exception {
        // called on a background thread
        return callingFunction();
    }

    @Override
    protected void done() {
        // called on the event dispatch thread after the work is done
        String result;
        try {
            result = get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        // do something with the result ...
        someTextField.setText(result);
    }
}.execute();