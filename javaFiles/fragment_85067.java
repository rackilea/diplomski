public void displayDistances(){
   for(int i = 0; i < members.length; i++){
      double total = 0;
      double[] distances = members[i].getTotalDistances();
      for(int j = 0; j < ditances.length; j++){  
         total += distances[j];
      }
      System.out.println(total);
   }
}