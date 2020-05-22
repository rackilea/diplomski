String str = "使 徒 行 傳 16:31 ERV-ZH";
  String pattern = "^([\\D\\s]+)";

  Pattern r = Pattern.compile(pattern);

  Matcher m = r.matcher(str);
  if (m.find( )) {
     System.out.println("Found value: " + m.group(0) );
  } else {
     System.out.println("NO MATCH");
  }
}