public static Integer[] convert(Object[] objectArray){
  Integer[] intArray = new Integer[objectArray.length];

  for(int i=0; i<objectArray.length; i++){
   intArray[i] = (Integer) objectArray[i];
  }

  return intArray;
 }