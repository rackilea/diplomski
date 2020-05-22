HashTable<Integer> t = new HashTable<Integer>();
Integer[] intArray = t.createArray(Integer.class, 4);
intArray[0] = 1; intArray[1] = 2;
intArray[2] = 3; intArray[3] = 4;

System.out.println(Arrays.toString(intArray));
> [1, 2, 3, 4]