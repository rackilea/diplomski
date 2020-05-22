String input = "Yes sir, 4 Chocolate milk";

//Pattern is: 
//- one or more words separated by whitespace as group 1: ((?:\\w+\\s*)+)
//- a comma 
//- optional whitespace: \\s*
//- an integer number as group 2: (\\d+)
//- optional whitespace \\s*
//- an arbitrary rest (which might contain anything) as group 3: (.*)
Pattern p = Pattern.compile( "((?:\\w+\\s*)+),\\s*(\\d+)\\s*(.*)" );
Matcher m = p.matcher( input );

List<String> list = new ArrayList<String>();
while(m.find()) {
  list.add( m.group( 1 ) );
  list.add( m.group( 2 ) );
  list.add( m.group( 3 ) );
}

Collections.reverse( list );
for( String s : list) {
  System.out.println(s);
}