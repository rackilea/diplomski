private void populateDrinkList() {

     myDrinks.add(new Drinks("a"));
     myDrinks.add(new Drinks("b"));
     myDrinks.add(new Drinks("c"));
     myDrinks.add(new Drinks("d"));
     myDrinks.add(new Drinks("e"));

     if (yourItems.contains("Vodka") || yourItems.contains("Gin") ) {

           Drinks toMoveUp = new Drinks("e");
            while (myDrinks.indexOf(toMoveUp) != 0) {
            int i = myDrinks.indexOf(toMoveUp);
            Collections.swap(myDrinks, i, i-1 );
    }


    }
    populateListView();
}