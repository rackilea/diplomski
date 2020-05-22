browser.setDialogHandler(new DialogHandler() {
    @Override
    public void onAlert(DialogParams params) {
        String url = params.getURL();
        String title = "The page at " + url + " says:";
        String message = params.getMessage();
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.PLAIN_MESSAGE);
    }