TextView textView = (TextView) findViewById(R.id.textView3);
textView.setMovementMethod(LinkMovementMethod.getInstance());

SpannableString spannableString = new SpannableString("your text");
spannableString.setSpan(new ClickableSpan() {
    @Override
    public void onClick(View widget) {
        // show your pop-up here
    }
}, 0, spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

textView.setText(spannableString);