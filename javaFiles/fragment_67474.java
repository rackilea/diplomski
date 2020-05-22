ArrayList<String> terms = new ArrayList<String>();
terms.add("term");
terms.add("the book is on the table");
terms.add("1981 was the best year ever!");
ArrayList<String> a  = new ArrayList<String>();
a.add("123term456");
a.add("A123Term5");
a.add("the book is on the table456");
a.add("1@#!231981 was the best year ever!9#");
for (String term: terms) {

    Pattern p = Pattern.compile("^[^A-Za-z]*(" + term + ")[^A-Za-z]*$");

    for(String text : a) {

        Matcher m = p.matcher(text);
        if (m.find()) {
             System.out.println("Found: " + m.group(1)  + " in " + text);
             //since the term you are adding is the second matchable portion, you're looking for group(1)
        }
        else System.out.println("No match for: " + term + " in " + text);
    }
}