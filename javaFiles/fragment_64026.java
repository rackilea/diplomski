private static void testForEach(ArrayList<String> als) {
  for(String s: als)
    System.out.println(s);
 }

 private static void testIterator(ArrayList<String> als) {
  for(Iterator<String> is = als.iterator(); is.hasNext();) {
   String s = is.next();
   System.out.println(s);
  } 
 }