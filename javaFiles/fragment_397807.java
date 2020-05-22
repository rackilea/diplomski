class MeaningOfLifeFinder extends SwingWorker<String, Object> {
    @Override
    public String doInBackground() throws SomeException {
        return findTheMeaningOfLife();
    }

    @Override
    protected void done() { // called in the EDT. You can update the GUI here, show error dialogs, etc.
        try { 
            String meaningOfLife = get(); // this line can throw InterruptedException or ExecutionException
            label.setText(meaningOfLife);
        } 
        catch (ExecutionException e) {
            Throwable cause = e.getCause(); // if SomeException was thrown by the background task, it's wrapped into the ExecutionException
            if (cause instanceof SomeException) {
                // TODO handle SomeException as you want to
            }
            else { // the wrapped throwable is a runtime exception or an error
                // TODO handle any other exception as you want to
            }
        }
        catch (InterruptedException ie) {
            // TODO handle the case where the background task was interrupted as you want to
        }
    }
}