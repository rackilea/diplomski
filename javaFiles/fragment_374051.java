String s = "ΠΑΡΑΘΥΡΟ";
char[] chars = s.toCharArray();
for (int i = 0; i < chars.length; i++) {
    Character repl = GREEK_TO_ROMAN.get(chars[i]);
    if (repl != null)
        chars[i] = repl;
    }
s = new String(chars);