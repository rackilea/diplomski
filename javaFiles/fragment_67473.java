String term = "term";
ArrayList<String> a  = new ArrayList<String>();
a.add("123term456"); //true
a.add("A123Term5"); //false
a.add("term456"); //true
a.add("123term"); //true
Pattern p = Pattern.compile("^[^A-Za-z]*(" + term + ")[^A-Za-z]*$");
for(String text : a) {
    Matcher m = p.matcher(text);
    if (m.find()) {
         System.out.println("Found: " + m.group(1) );
         //since the term you are adding is the second matchable portion, you're looking for group(1)
    }
    else System.out.println("No match for: " + term);
}