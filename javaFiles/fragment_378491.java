public static void getAllMatches(Pattern p, String in, List<String> out) {
  Matcher m = p.matcher(in);           // get matches in input
  while (m.find()) {                   // for each match
    out.add(m.group(2));               // add match to result array
    getAllMatches(p, m.group(2), out); // call function again with match as input
  }
}