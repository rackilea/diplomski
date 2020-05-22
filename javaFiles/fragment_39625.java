Random r = new Random();
long l = 10;
int lowBound =1;
int highBound =100;
int[] myArray = r.ints(l, lowBound, highBound).toArray();

System.out.println(Arrays.toString(myArray));