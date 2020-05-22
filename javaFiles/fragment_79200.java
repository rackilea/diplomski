/* Create a scanner for the system in. */
Scanner scan = new Scanner(System.in);
/*
 * Create a regex that looks for numbers formatted like:
 * 
 * A an optional '+' sign followed by 1 or more digits; OR A '-'
 * followed by 1 or mored digits.
 * 
 * If you want to make the '+' sign mandatory, remove the question mark.
 */
Pattern p = Pattern.compile("(\\+?(\\d+))|(\\-\\d+)");

/* Get the next token from the input. */
String input = scan.next();
/* Match the input against the regular expression. */
Matcher matcher = p.matcher(input);
/* Does it match the regular expression? */
if (matcher.matches()) {
    /* Declare an integer. */
int i = -1;
/*
 * A regular expression group is defined as follows:
 * 
 * 0 : references the entire regular expression. n, n != 0 :
 * references the specified group, identified by the nth left
 * parenthesis to its matching right parenthesis. In this case there
 * are 3 left parenthesis, so there are 3 more groups besides the 0
 * group:
 * 
 * 1: "(\\+?(\\d+))"; 2: "(\\d+)"; 3: "(\\-\\d+)"
 * 
 * What this next code does is check to see if the positive integer
 * matching capturing group didn't match. If it didn't, then we know
 * that the input matched number 3, which refers to the negative
 * sign, so we parse that group, accordingly.
 */
if (matcher.group(2) == null) {
    i = Integer.parseInt(matcher.group(3));
} else {
    /*
     * Otherwise, the positive group matched, and so we parse the
     * second group, which refers to the postive integer, less its
     * '+' sign.
     */
        i = Integer.parseInt(matcher.group(2));
    }
    System.out.println(i);
} else {
    /* Error handling code here. */
}