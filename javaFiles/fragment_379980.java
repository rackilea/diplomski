Pattern p = Pattern.compile(Pattern.quote(textToMatche));
Matcher m = p.matcher(text);
int count = 0;
while (m.find()) {
    count += 1;
}