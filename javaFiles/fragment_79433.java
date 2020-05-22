bbMap.put("\\[b\\]", s -> "<strong>");
bbMap.put("\\[/b\\]", s -> "</strong>");
//...
bbMap.put("\\[color=(.+?)\\]", s -> "<span style='color:" + s + ";'>");
bbMap.put("\\[/color\\]", s -> "</span>");

bbMap.put("\\[\\!(.+?)\\]", s -> Dialogue.pause(s));

for (Map.Entry entry : bbMap.entrySet()) {
    StringBuffer buffer = new StringBuffer(html.length());

    Matcher matcher =
        Pattern.compile(entry.getKey().toString()).matcher(html);
    while (matcher.find()) {
        String match =
            (matcher.groupCount() > 0 ? matcher.group(1) : null);
        String replacement = entry.getValue().apply(match);
        matcher.appendReplacement(buffer,
            Matcher.quoteReplacement(replacement));
    }
    matcher.appendTail(buffer);

    html = buffer.toString();
}