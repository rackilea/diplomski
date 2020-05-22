private Map<MyClass, Integer> map(int[] array){
  Map<MyClass, Integer> arrayMap = new HashMap<>();
  for (int i; i<array.length; i++)
        arrayMap.put(new MyClass(array[i]), i);
}

private mySearch(){
   int[] array1, array2, array3;

   Map<MyClass, Integer> map1 = map(array1);
   Map<MyClass, Integer> map2 = map(array2);

   for (int i=0; i<array3.lenght; i++){
      MyClass row = new MyClass(array3[i]);
      Integer array1Row = map1.get(row);
      Integer array2Row = map2.get(row);

      if (array1Row != null && array2Row != null){
         // Matching rows found
      }
   }
}