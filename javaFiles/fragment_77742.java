StringBuilder sb = new StringBuilder();
 int n = s.length();
 for (int i = 0; i < n; i++) {
     char c = s.charAt(i);
     if (Character.UnicodeBlock.of(c) != Character.UnicodeBlock.BASIC_LATIN) {
        sb.append("&#");
        sb.append((int)c);
        sb.append(';');
     } else {
        sb.append(c);
     }

 }