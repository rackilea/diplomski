SpannableStringBuilder builder = new SpannableStringBuilder();
for(String word: words) {
    builder
            .append(word)
            .setSpan(new ClickableSpan() {
                @Override
                public void onClick(@NonNull View view) {
                    // on click
                }

                // optional - for styling the specific text
                /*@Override
                public void updateDrawState(@NonNull TextPaint textPaint) {
                    textPaint.setColor(textPaint.linkColor);    // you can use custom color
                    textPaint.setUnderlineText(false);    // this remove the underline
                }*/
            }, builder.length() - word.length(), builder.length(), 0);

}