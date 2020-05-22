String str = "test, west, best, zest, jest";

// Matches against "non-commas", then a comma, then "non-commas", then 
// a comma, then "non-commas". This way, you still don't have a trailing
// comma at the end.
Matcher match = Pattern.compile("^([^,]*,[^,]*,[^,]*)").matcher(str);

if(match.find())
{
    // Print out the output!
    System.out.println(match.group(1));
}
else
{
    // We didn't have a match. Handle it here.
}