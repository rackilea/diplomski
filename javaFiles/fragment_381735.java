private void setResultAndFinish() {
    EditText editText = (EditText)findViewById(R.id.surveyadd_name_edittext);
    String title = editText.getText().toString();
    if (!TextUtils.isEmpty(title)) ) {
        Intent intent = new Intent();
        intent.putExtra("title", title);
        setResult(RESULT_OK, intent);
        finish();
    } else {
        Toast.makeText(context, R.string.surveyadd_warn_notitle, Toast.LENGTH_SHORT).show();
    }
}