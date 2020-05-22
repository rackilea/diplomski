String text = <TEXT>;
int next;
Pattern p = Pattern.compile("\\? |! |\\. ");
Matcher m = p.matcher(text);
if (m.find()) {
   int next = m.start();
} else next = -1;