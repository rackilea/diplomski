class countingSubString
 {
    int countSubString(String strOne, String strTwo, int count)
    {
      if (strOne == null || strOne.equals("") || strOne.length() < strTwo.length())
        return 0;

      int index =  strOne.indexOf(strTwo);
      if(index!=-1){
        count++;
        count+= countSubString(strOne.substring(index+1),strTwo,0);
      }

      return count;
   }
}