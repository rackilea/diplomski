Element td = ...;
StringBuilder sb = new StringBuilder();
for (TextNode textNode : td.textNodes()) {
    sb.append(textNode.text());
}
return sb.toString();