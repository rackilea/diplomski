Matcher numericalMatcher = Pattern.compile("^-?\\d+$").matcher(token);
if( numericalMatcher.matches() ) {
   // Token is a number
} else {
   // Token is not a number
}