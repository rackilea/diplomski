public boolean isEmptyStringArray(String [] array){
 for(int i=0; i<array.length; i++){ 
  if(array[i]!=null){
   return false;
  }
  }
  return true;
}