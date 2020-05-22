Set<String> set = new HashSet(Arrays.asList(new String [] {"One", "Two", "Three"}));
Iterator i = set.iterator();
// Consume the first.
String first = i.next();
for ( String s : i ) { // Error here.

}