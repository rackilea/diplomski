// With java 8

int[] positivesCase3 = Arrays.stream(source).filter(n -> n>=0).toArray();
int[] negativesCase3 = Arrays.stream(source).filter(n -> n<0).toArray();

System.out.println(Arrays.toString(positivesCase3)); // [4, 6, 2]
System.out.println(Arrays.toString(negativesCase3)); // [-3, -1]