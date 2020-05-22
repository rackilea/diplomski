// new double-dimension int array
//                   | conversion here
//                   |                  | specifying 1st dimension's size as list's 
//                   |                  | size
int[][] converted = ls.toArray(new int[ls.size()][]);

// test it
System.out.println(Arrays.deepToString(converted));