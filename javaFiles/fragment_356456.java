String input = "Hello ${123...456}, bye ${789...101112}";
//                           | escaped "$"
//                           |  | escaped "{"
//                           |  |  | first group (any number of digits)
//                           |  |  |    | 3 escaped dots
//                           |  |  |    |       | second group (same as 1st)
//                           |  |  |    |       |    | escaped "}"
Pattern p = Pattern.compile("\\$\\{(\\d+)\\.{3}(\\d+)\\}");
Matcher m = p.matcher(input);
// iterating over matcher's find for multiple matches
while (m.find()) {
    System.out.println("Found...");
    System.out.println("\t" + m.group(1));
    System.out.println("\t" + m.group(2));
}