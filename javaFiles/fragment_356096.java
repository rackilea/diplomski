// \d+ matches a number. \s* matches any number of spaces.
String milePattern = "(\\d+)\\s*((miles)|(mile)|(mil))";
String kmPattern = "(\\d+)\\s*((kilometers)|(km)|(kilometres))";

// Compile the patterns (you should not do that at each method call, in your real code)
Pattern mileP = Pattern.compile(milePattern);
Pattern kmP = Pattern.compile(kmPattern);

// You can match one or multiple lines all the same.
String input = "I ran 1001km or 601 mile \n that is the same as 602 mil or 603miles or 1002 kilometers.";

// Create matcher instance on your input.
Matcher mileM = mileP.matcher(input);
// Iterate over all mile-matches (find will 'advance' each time you call it)
while (mileM.find()) {
    // Retrieve the value and the unit
    String amount = mileM.group(1);
    String unit = mileM.group(2);

    // You can also access some data about the match
    int idx = mileM.start();

    // And do whatever you need with it
    System.out.println("Found a mile value: " + amount + " with unit " + unit + " starting at index: " + idx);
}