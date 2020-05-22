static Map<String,String> getVideoIdFromUrl(String url) {

  // PATTERN
  String regex = "v=([^#&\n\r]+)|t=([^#&\n\r]+)";

  // INIT RETURN DATA
  String id = "";
  String time = "";

  // RUN REGEX
  Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
  Matcher matcher = pattern.matcher(url);

  // CHECK 
  while (matcher.find()) {

      // SET ID
      if(matcher.group(1) != null)
          id = matcher.group(1);

      // SET TIME
      if(matcher.group(2) != null)
          time = matcher.group(2);

  }

  // BUILD RETURN DATA
  Map<String,String> returnData = new HashMap<String, String>();
  returnData.put("id", id);
  returnData.put("time", time);

  // RETURN
  return returnData;

}