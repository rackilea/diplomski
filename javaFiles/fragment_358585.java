String in = stdIn.nextLine();
// Need to escape the characters because
// these characters mean something special in regular expressions
String filtered = userInput.replaceAll("(\\[\\{\\}\\],"," ");
String[] numbers = filtered.split("\\s+");
ArrayList <Integer> myNumbers = new ArrayList <Integer> ( numbers.length );
for ( String number : numbers )
    myNumbers.add ( Integer.parseInt ( number ) );