button.setEnabled(false);
...    
@Override
protected String doInBackground() throws Exception {
    // process related code
    return "";
}

@Override
protected void done() {
    button.setEnabled(true);
}