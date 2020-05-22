// 1 object, an array with 10 elements (set to zero)
int[] array = new int[10]; 

// 1 objects, an array with 10 elements (set to null)
String[]  str = new String[10];  

// 1 object, an array with 10 elements pointing at objects 
// that have been preallocated within the String pool.  See 
// the appendium below for evidence.
String[] str = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }; 

// 3 objects, one for the array and one per integer.
Integer[] a4 = new Integer[] { new Integer(1), new Integer(2) }; 

// 1 object again, Java has an Integer pool of limited size which is used
// to optimise auto boxing; 1 and 2 will definitely be within that default
// range
Integer[] a6 = new Integer[] { 1, 2 }; 

// 3 objects, the default size of the int pool is fairly low
// but it can be increased via a JVM flag.
Integer[] a5 = new Integer[] { 1000, 2000 }; 

// 3-5 objects -- 1 for the array, one for each of the string objects and 1 
// per char array backing the string.  Depending on JVM version the char 
// array may be shared with the interned strings, so that one is a little tricky
// and is why I said 3-5.
String[] str = {new String("1"), new String("2")};