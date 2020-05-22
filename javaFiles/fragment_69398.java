public static void main(String[] args) {

   List<String> lines = Arrays.asList("AAA", "BBB", "AAA", "BBB", "CCC", "CCC");

   List<String> filteredList = new ArrayList<>();
   for (String s: lines) {
       if(s.equals("BBB")) {
           filteredList.add(s);
       }
   }

   System.out.println(filteredList);  // output - [BBB, BBB]
}