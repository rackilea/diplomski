Pattern pattern = Pattern.compile(",\\s*"); // Best static final.
Matcher m = pattern.matcher(stringBuilder);
int pos0 = 0;
while (m.find()) {
    int pos1 = m.start();
    CharSequence cs = stringBuilder.subSequence(pos0, pos1);
    ...
    pos0 = pos1;
}
CharSequence cs = stringBuilder.subSequence(pos0, stringBuilder.length());
...