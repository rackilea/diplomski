public static void main(String[] args) {
   List<String> lines = Arrays.asList("AAA", "BBB", "AAA", "BBB", "CCC", "CCC");

   for (String s: lines) {
       if(s.equals("BBB")) {
           System.out.println(s);
       }
   }

// output
// BBB
// BBB
}