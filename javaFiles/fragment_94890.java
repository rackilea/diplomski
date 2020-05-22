ListView<Topping> listView = new ListView<>();
List<Topping> toppings = Arrays.asList(
    new Topping("Cheese"), 
    new Topping("Pepperoni") , 
    new Topping("Black Olives"));
listView.getItems().addAll(toppings);

listView.setCellFactory(CheckBoxListCell.forListView(Topping::selectedProperty));