//1. Reset data to null, even if 2 is not executed yet.
data = null;
    try {
    data = ois.readLine();
} catch (IOException e) {
    e.printStackTrace();
}

if (data != null){
    Log.d("Test", data);

    //Cache the current value
    final String dataCopy = data;
    //2. Start this code some where in the future...
    runOnUiThread(new Runnable() {
        @Override
        public void run() {
            input_txt.setText(dataCopy+"");
        }
    });
}