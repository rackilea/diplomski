TextView textView = findViewById(R.id.tvSample);
    SpannableStringBuilder stringBuilder  =new SpannableStringBuilder(textView.getText());
    stringBuilder.setSpan(new ForegroundColorSpan(Color.BLUE),textView.getText().length()-20,textView.getText().length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
    stringBuilder.setSpan(new ClickableSpan() {
        @Override
        public void onClick(final View view) {
            Toast.makeText(MainActivity.this,"Click",Toast.LENGTH_LONG).show();
        }
    },textView.getText().length()-20,textView.getText().length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
  textView.setText(stringBuilder);