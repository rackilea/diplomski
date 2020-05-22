public String replaceFirst(String replacement) {
    if (replacement == null)
        throw new NullPointerException("replacement");
    reset();
    if (!find())
        return text.toString();
    StringBuffer sb = new StringBuffer();
    appendReplacement(sb, replacement);
    appendTail(sb);
    return sb.toString();
}