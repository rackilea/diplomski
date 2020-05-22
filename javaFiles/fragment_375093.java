String contents = ...
   Pattern p = Pattern.compile("\\wmain\\w([^}]*)}",
                               Pattern.MULTILINE | Pattern.DOTALL);
   Matcher m = p.matcher(content);
   if (m.find()) {
       String matched = m.group(1);
       ...
   } else {
       ...
   }