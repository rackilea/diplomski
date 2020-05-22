Button button = (Button) findViewById(R.id.button);
button.setOnClickListener(new OnClickListener{
    public void onClick() {
        Intent intent = new Intent(getApplicationContext(), <next activity>.class);
        intent.putExtra("maxNumberPressed", editText.getText());
        startActivity(intent);
    }
});