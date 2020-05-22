Pattern p = Pattern.compile("Fruits(.*?)Sports", Pattern.DOTALL);
// The string "Fruits" ------^     ^    ^        ^
// Capture everything in between --^    ^        ^
// The string "Sports" -----------------^        ^
// This tells the regex to treat newlines        ^
//   like normal characters ---------------------^