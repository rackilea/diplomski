EditText set_limit = findViewById(R.id.editText2);
CharSequence text = set_limit.getText();
if (TextUtils.isEmpty(text)) {
    // handle case of no text
} else {
    try {
        int limit_number = Integer.parseInt(text.toString());
        Intent intent = new Intent(A.this, B.class);
        intent.putExtra("limit_basic", limit_number);
        startActivity(intent);
    } catch (NumberFormatException e) {
        // handle case of improperly formatted text
    }
}