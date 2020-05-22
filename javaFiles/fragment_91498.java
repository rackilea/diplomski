// process the first 10 matches
// no while-loop!
for (int i = 0; i < 10 && matcher.find(); i++) {
   String output = matcher.group(0);
   ...
}