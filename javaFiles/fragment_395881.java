class Line extends Thread {
        public void run() {
    DrawingUtils call = new DrawingUtils();
    EditText cl = (EditText) findViewById(R.id.editText1);
    String in = cl.getText().toString();
    call.setInputCoords(in);
    notifyAll();
        }

};