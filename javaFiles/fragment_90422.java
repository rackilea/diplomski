Collections.sort(arrayList, new Comparator<Stack<Integer>>(){
  public int compare(Stack<Integer> list1, Stack<Integer> list2){
      int result = Integer.compare(list1.size(), list2.size());
      for (int i = 0; result == 0 && i < list1.size(); i++)
      {
        result = Integer.compare(list1.get(i), list2.get(i));
      }
      return result;
  }
});