MainActivity.this.runOnUiThread(new Runnable() {
    public void run() {
        TextView textView = (TextView) findViewById(R.id.editText);
        textView.setText(sentence);
    }
});