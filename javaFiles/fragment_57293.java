Pattern pattern = Pattern.compile("([0-9]+)"); // outside of method

long[] ArgArray = new long[3];
Matcher matcher = pattern.matcher(Arguments);
int i = 0;
while (matcher.find() && i < 3) {
   ArgArray[i++] = Long.parseLong(matcher.group(1));
}
// there was a mistake if i < 3, otherwise you have 3 numbers in ArgArray