private void buildDialog() {
    // build your dialog with everything
    dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int whichButton) {
            // do what you want with the value
            doSomethingWithValue(value);
        }
    });
}

protected void doSomethingWithValue(String value) {
    Log.i("MyTAG", value);
}