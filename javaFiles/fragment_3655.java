public void addTopping(Topping topping) {
    setOfToppings.add(topping);
}

public Set<Topping> getToppings() {
    return setOfToppings;
}

public void addManyToppings(Topping... toppings) {
    setOfToppings.addAll(Arrays.asList(toppings));
}