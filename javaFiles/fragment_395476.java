public static void removeFromList(String[] input, List<String> list){
  if(input.length == 2 && input[1].matches("\\d+")){
      int index = Integer.parseInt(input[1]);
      if(index < list.size()){
         list.remove(index);
      } else {
         System.out.println("Invalid index: " + index);
      }
   } else {
      System.out.println("Invalid input: " + Arrays.toString(input));
   }
}