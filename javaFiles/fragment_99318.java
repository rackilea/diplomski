Integer [] intArray = new Integer[10];
intArray[0] = 5;
//Rest of indexes are null
boolean isArrayFull = true;
for (Integer i:intArray){
   if (i==null){
      isArrayFull = false; //Enter here only if at least one index is null/empty.
   }
}
System.out.println(isArrayFull?"YES":"NO");