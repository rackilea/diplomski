Pattern greedy = Pattern.compile("[, !.]+");
Pattern reluctant = Pattern.compile("[, !.]+?");
Pattern nonQuantified = Pattern.compile("[, !.]");
String example = "foo !! bar";
Matcher greedyMatcher = greedy.matcher(example);
Matcher reluctantMatcher = reluctant.matcher(example);
Matcher nonQMatcher = nonQuantified.matcher(example);
while (greedyMatcher.find()) {
    System.out.printf("Greedy found: %s%n", greedyMatcher.group());
}
while (reluctantMatcher.find()) {
    System.out.printf("Reluctant found: %s%n", reluctantMatcher.group());
}
while (nonQMatcher.find()) {
    System.out.printf("Non-quantified found: %s%n", nonQMatcher.group());
}