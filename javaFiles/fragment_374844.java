showMessageBox(MainActivity.this, "Title", "Message", new MessageBoxListener() {
    @Override
    public void result(int result) {
        if (result == 1) 
            // Do something
        else
            // Do something else
    }
});