public static void main(String args[]){
   String[] alpha= {"A","B","C","D"};
   for (int i = 0 ; i < alpha.length ; i++){
      if(Integer.valueOf(args[0]) == i){
          System.out.println(alpha[i] + " is at position " +i);
      }
   }
}