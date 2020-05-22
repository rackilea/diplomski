private final Handler handler = new Handler();

public void onButtonClick(View v) {
    EditText text = (EditText)findViewById(R.id.editText1);
    String id = text.getText().toString();

    new parseURL() {
        @Override
        protected void onPostExecute(List<String> list) {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    updateUI(list);
                }
            })
        }
    }
}