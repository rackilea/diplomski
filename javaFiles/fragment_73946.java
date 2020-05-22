public void onSendRecipeName(View view) {
    editText = (EditText) findViewById(R.id.recipe_name_edit_text);
    Intent goingBack = new Intent();
    goingBack.putExtra("newItem",editText.getText().toString());
    setResult(RESULT_OK, goingBack);
    finish();
}