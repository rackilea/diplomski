int[] someInts = {3,2,6,7, /*...,*/ 99};

// use a TreeSet
TreeSet<Integer> ints = new TreeSet<Integer>();
for (int i : someInts)
    ints.add(i);

System.out.println(ints.contains(2)); // true      
System.out.println(ints.contains(5)); // false

// or sort the array and use Arrays.binarySearch
Arrays.sort(someInts);
System.out.println(Arrays.binarySearch(someInts, 2) >= 0); // true
System.out.println(Arrays.binarySearch(someInts, 5) >= 0); // false