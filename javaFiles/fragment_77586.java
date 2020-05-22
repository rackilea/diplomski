String test = "bla bla...this is the tag id of product: #31 5 2 0000 12, please verify bla bla...";
// explanation of the Pattern:
//                                |starts with "#"
//                                | |directly followed by digits only
//                                | |   |character class including digits or spaces
//                                | |   |       |ad lib (greedy quantifier)
Pattern pattern = Pattern.compile("#\\d+[\\d\\s]+");

Matcher matcher = pattern.matcher(test);
// using a while group here so you may have multiple matches
while (matcher.find()) {
    System.out.println(matcher.group());
}