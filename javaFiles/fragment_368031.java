public String text_mod(){
    StringBuilder sb = new StringBuilder();
    text_mod(sb);
    return sb.toString().trim().replaceAll("\n+", "\n");
}

private void text_mod(StringBuilder accum) {
    appendWhitespaceIfBr(this, accum);

    for (Node child : childNodes) {
        if (child instanceof TextNode) {
            TextNode textNode = (TextNode) child;
            appendNormalisedText(accum, textNode);
        } else if (child instanceof Element) {
            Element element = (Element) child;
    //        if (accum.length() > 0 && element.isBlock() && !TextNode.lastCharIsWhitespace(accum))
    //            accum.append("\n");
            element.text_mod(accum);
        }
        accum.append("\n");
    }
}