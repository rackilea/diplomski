public static String processFuction(String input, List<String> patternList, String replace)
            throws Exception {
  try {
        for (String pattern : patternList){
          Pattern p = Pattern.compile(pattern);
          Matcher m = p.matcher(input);
          input = m.replaceAll(replace);// do your operation 
        }
   } catch (Exception ex) {
       logger.severe(ex.getMessage());
   }
  return input;
}