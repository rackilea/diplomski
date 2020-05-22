String matched = "two";
List<String> values = Arrays.asList("one", "two", "three <escape-me>");
SafeHtmlBuilder builder = new SafeHtmlBuilder();
for (String v : values){
  if (v.equals(matched)){
    builder.appendHtmlConstant("<b>");
    builder.appendEscaped(v);
    builder.appendHtmlConstant("</b>");
  } else {
    builder.appendEscaped(v);
  }
  builder.appendEscaped(", ");
}
HTML widget = new HTML();
widget.setHTML(builder.toSafeHtml());
//div contains the following HTML: "one, <b>two</b>, three &lt;escape-me&gt;, "