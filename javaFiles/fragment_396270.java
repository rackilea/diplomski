Pattern pattern = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");
  Matcher matcher = pattern.matcher(dateTime);
  if (matcher.find())
  {
     System.out.println(matcher.group());
  }