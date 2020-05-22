Pattern outer = Pattern.compile("\\[.*?\\]");
Pattern inner = Pattern.compile("\"\\s*,\\s*\"");
Matcher mOuter = null;
Matcher mInner = null;

mOuter = outer.matcher(jsonString);
StringBuffer sb = new StringBuffer();

while (mOuter.find()) {
    mOuter.appendReplacement(sb, "");
    mInner = inner.matcher(mOuter.group());
    while (mInner.find()) {
        mInner.appendReplacement(sb, "\"\"");
    }
    mInner.appendTail(sb);
}
mOuter.appendTail(sb);

System.out.println(sb.toString());