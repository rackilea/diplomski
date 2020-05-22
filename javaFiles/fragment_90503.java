List<SoftDrink>  drinks= new ArrayList<SoftDrink>();

SoftDrink drink;
for(int i=0;i<numberOfDrinks;i++) {
  drink = new SoftDrink();
  drink.setname(...);
  drinks.add(drink);
}

//Sorting
Collections.sort(drinks, new Comparator<SoftDrink>() {
        @Override
        public int compare(SoftDrink  drink1, SoftDrink  drink2) {
            return  drink1.drinkName.compareTo(drink2.drinkName);
        }
    });