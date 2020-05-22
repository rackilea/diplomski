private void searchFor(String text) {
    TextView prose=(TextView)findViewById(R.id.prose);
    Spannable raw=new SpannableString(prose.getText());
    BackgroundColorSpan[] spans=raw.getSpans(0,
                                             raw.length(),
                                             BackgroundColorSpan.class);

    for (BackgroundColorSpan span : spans) {
      raw.removeSpan(span);
    }

    int index=TextUtils.indexOf(raw, text);

    while (index >= 0) {
      raw.setSpan(new BackgroundColorSpan(0xFF8B008B), index, index
          + text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
      index=TextUtils.indexOf(raw, text, index + text.length());
    }

    prose.setText(raw);
  }