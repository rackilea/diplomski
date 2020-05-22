int isTrue = 0;
for (boolean bool : new boolean[]{true,false,false,false,false}) {
   if (bool && ++isTrue > 1) {
      System.out.println("More than 1!");
      break;
   }
}