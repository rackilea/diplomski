public static void main(String[] args) {
  List<String> list = Arrays.asList("aa", "bb", "cc", "DDD", "happy", "snow");

  for(int i =0; i<list.size(); i+=2){
       Collections.swap(list, i, (i+1));
  }
  System.out.println("The new list = " + list);
}