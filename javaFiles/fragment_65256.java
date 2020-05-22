while (!word.matches("\\w{3,}")) {  // don't match more than 3
   //
}

// -- OR --

while (word.matches("\\w{0,3}")) {  // match between 0 and 3 is also correct
   //
}