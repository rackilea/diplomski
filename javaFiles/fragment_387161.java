private final Handler handler = new Handler() {
    public void handleMessage(Message msg) {
        if(msg.what == 1) {
            List<String> list = (List) msg.obj;
            updateUI(list);
        }
    }
}

public void onButtonClick(View v) {
    EditText text = (EditText)findViewById(R.id.editText1);
    String id = text.getText().toString();

    new parseURL() {
        @Override
        protected void onPostExecute(List<String> list) {
            handler.obtainMessage(1, list).sendToTarget();
        }
    }
}