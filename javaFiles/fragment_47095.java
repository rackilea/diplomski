String s = "AATTAAAATTTTAAAAAAAAGGGCCCTTTAAATATATATATATATAAGGGATTTAAGGAATTAAGATGATGATGATGATGATGGTAG";
Pattern pattern = Pattern.compile("([ATGC][ATGC])\\1+");
Matcher matcher = pattern.matcher(s);

while (matcher.find()) {
    System.out.print("Start index: " + matcher.start());
    System.out.print(" End index: " + matcher.end());
    System.out.println(" Found: " + matcher.group());
}