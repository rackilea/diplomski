TextView textView = (TextView) findViewById(R.id.textView);
c.get(new MyClientCallback() {
    @Override
    public void onResponse(String value) {
        textView.setText(value);
    }
});