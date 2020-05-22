public static void main(String[] args) {
 String input = "5006,3030,8080-8083";
 List<Integer> list = new ArrayList<Integer>();
 String[] numbers = input.split(",");

 for (String s : numbers) {
    if (s.contains("-")) {
      String[] range = s.split("-");
      int from = Integer.parseInt(range[0]);
      int to = Integer.parseInt(range[1]);
      for (int i = from; i <= to; i++) {
         list.add(i);
      }
    } 
    else {
      list.add(Integer.parseInt(s));
    }
 }

System.out.println("in asc order");
Collections.sort(list);
System.out.println(list.toString());

System.out.println("in desc order");
Collections.reverse(list);
System.out.println(list.toString());

}