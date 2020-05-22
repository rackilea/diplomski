String str = s.toString();
Pattern pattern = Pattern.compile("(\\d+)'((\\d+)\")?");
Matcher matcher = pattern.matcher(str);
if (!matcher.matches()) {
    return;
}

int feet = Integer.parseUnsignedInt(matcher.group(1));
String inchesStr = matcher.group(3);
int inches = 0;
if (inchesStr != null) {
    inches = Integer.parseUnsignedInt(inchesStr);
}

// YAY! you got your feet and inches!