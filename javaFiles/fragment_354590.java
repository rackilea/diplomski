Regex r = new Regex("YOURREGEX");

// search for a match within a string
r.search("YOUR STRING YOUR STRING");

if(r.didMatch()){
// Prints "true" -- r.didMatch() is a boolean function
// that tells us whether the last search was successful
// in finding a pattern.
// r.left() returns left String , string before the matched pattern 
int index = r.left().length();
}