String yearStr = sc.next(); // always read the word, even if invalid
int rok = Integer.MIN_VALUE; // value to use if year is invalid.
try {
    rok = Integer.parseInt(yearStr);
} catch (InvalidArgumentException e) {
    System.out.println("Ignoring invalid year " + yearStr);
}