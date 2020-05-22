Iterator<String> iter = set.iterator();

int lengthSoFar = 0;
String str = null;

while ( lengthSoFar < k && iter.hasNext() ) {

     str = iter.next();           // Got the next substring;
     lengthSoFar += str.length();
}

// At this point we have the substring where we expect the k'th
// character to be.

System.out.println( str.charAt( k - lengthSoFar + str.length() - 1 );