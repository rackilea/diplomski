// content = content.replaceAll("xyz", "xyz" + generateUUID());
StringBuilder sb = new StringBuilder(content);
String toReplace = "xyz";
int toReplaceLen = toReplace.length();
int pos;
while ((pos = sb.indexOf(toReplace)) > -1) {
    sb.replace(pos, pos + toReplaceLen, generateUUID());
}
// content = sb.toString(); // <-- if you want to use content.