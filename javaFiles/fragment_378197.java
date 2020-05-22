while (matcher.find()) {
    ForegroundColorSpan hash_color =
        ForegroundColorSpan(cxt.getResources().getColor(R.color.light_blue));
    spannable.setSpan( hash_color, matcher.start(), matcher.end(),
                       Spanned.SPAN_EXCLUSIVE_EXCLUSIVE );
}