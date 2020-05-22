public int indexOf(String s) throws StringNotFoundException {
     for(int i=0;i<strArr.length ;++i) {
         if (strArr[i].equals(s)){
             return i;
         }
     }
     throw new StringNotFoundException();
}