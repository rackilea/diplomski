String a = "badabcde";
char[] chArr = a.toCharArray(); // 'b','a','d','a','b','c','d','e'

// fromIndex - the index of the first element (inclusive) to be sorted
// toIndex - the index of the last element (exclusive) to be sorted
Arrays.sort(chArr,2,6);