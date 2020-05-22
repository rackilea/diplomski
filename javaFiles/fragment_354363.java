SpannableString span = new SpannableString(s);
for (int i = 0; i < span.length(); i++) {
    if (Character.isDigit(span.charAt(i)))
         continue;

    span.setSpan(new TypeFace("", Typeface.createFromAsset(context.getAssets(),
        "fonts/font.ttf")), i, i+1, span.SPAN_INCLUSIVE_INCLUSIVE);
}