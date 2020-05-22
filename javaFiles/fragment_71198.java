ClickableSpan clickableSpanPrivacyPolicy = new ClickableSpan() {
    @Override
    public void updateDrawState(TextPaint ds) {
        super.updateDrawState(ds);
        ds.setColor(Color.BLUE);
        ds.setUnderlineText(true);
    }

    @Override
    public void onClick(View widget) {
        // Do something
    }
};