public ArrayList<Lamborghini> getCarsFromThisYear(int year) {
   ArrayList<Lamborghini> thisYearLamb = new ArrayList<Lamborghini>();
   for(Lamborghini cars : inventory)
   { 
      if(cars.getModelYear() == year) {
         thisYearLamb.add(cars);
      }
   }          

   return thisYearLamb;
}