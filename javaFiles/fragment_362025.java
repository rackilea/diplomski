String test = "This is a String with [the substring I want].";
//                          | preceding "[", not matched
//                          |      | any 1+ character, reluctant match
//                          |      |  | following "]", not matched
//                          |      |  | 
Pattern p = Pattern.compile("(?<=\\[).+?(?=\\])");
Matcher m = p.matcher(test);
if (m.find()) {
    System.out.println(m.group());
}