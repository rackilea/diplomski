Spanned text = Html.fromHtml(myHtmlString);
ForegroundColorSpan spans[] = text.getSpans(0, text.length(),
    ForegroundColorSpan.class);
if (spans.length > 0) {
    myTextView.setLinkTextColor(spans[0].getForegroundColor());
}
myTextView.setText(text);