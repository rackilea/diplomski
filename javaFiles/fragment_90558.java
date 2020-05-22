if (animals.get(i) instanceof Dog){
    if(animals.get(i).getName().equals(name))
    {
         ((Dog) animals.get(i)).Edit(name, color, diet, habitat, temperament, breed);
    }
}