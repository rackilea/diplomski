in = in.trim(); // don't fool around with white space.
                // throws NullPointerException if null 
int len = in.length();
if ( len == 0 ) {
    throw new NumberFormatException("empty String");
}