public void  eatFood(){
   System.out.println("Enter food: ");
   food = in.nextLine();    
   if(food.matches(foodTypes[0])){
      System.out.println("woof");
      hungerLvl++;
      System.out.println("Hunger lvl incresead to " + hungerLvl);
   } else {
       if (food.matches(foodTypes[1])){
           System.out.println("Animal is eating grass");
           hungerLvl++;
       }
       if (food.matches(foodTypes[2])){
           System.out.println("Animal is drinking water");
           hungerLvl++;
       }           
   }  
}