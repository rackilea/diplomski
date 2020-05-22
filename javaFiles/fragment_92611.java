public List<Integer> getIndexesOfStr(String fullStr, String strToFind){
  ArrayList<Integer> listOfIndexes = new ArrayList<>();

  int index = fullStr.indexOf(strToFind, 0);
  while(index >= 0)
  {
    listOfIndexes.add(index);
    index = fullStr.indexOf(strToFind, index + strToFind.length());
  }
  return listOfIndexes;
}