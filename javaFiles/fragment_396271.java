String dateTime = "2014-05-19T23:59:59"; 
  // pattern for 'yyyy-MM-dd%'
  Pattern pattern = Pattern.compile("(\\d{4})-(\\d{2})-(\\d{2}).+");
  Matcher matcher = pattern.matcher(dateTime);
  if (matcher.matches())
  {
     // date in format 'MM/dd/yyyy'
     String dateInNewFormat = String.format("%s/%s/%s", 
        matcher.group(2), matcher.group(3), matcher.group(1));
  }