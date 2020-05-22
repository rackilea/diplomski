Object intArray = new  int[]{7, 9, 8};
Object[] intintArray  = new int[][]{{1, 2, 3}, {6, 5, 4}};
Object[] intintintArray  = new int[][][]{{{1, 2, 3}, {6, 5, 4}},
               {{1, 2, 3}, {6, 5, 4}}};
System.out.println(arrayToString(intArray));
System.out.println(arrayToString(intintArray));
System.out.println(arrayToString(intintintArray));