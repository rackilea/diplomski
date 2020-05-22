double score;
String line = input.nextLine();
if ( "s".equals(line) ) {
   // skip
} else try {
   score  = Double.parse(line);
} catch ( NumberFormatException nfe ) { 
  // it wasn't a valid double... handle here
}