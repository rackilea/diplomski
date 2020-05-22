final SpannableStringBuilder builder = new SpannableStringBuilder();
...
for (Element link : links) {
    final String url = link.attr("href");
    builder.
            ....
            .append("Link: ")
            .append(url, new URLSpan(url), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            .append("\n")
            ...
}