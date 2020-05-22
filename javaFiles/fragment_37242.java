class Animal{
    //props
}   

class Cat extends Animal{
    public void sayMeow(){} 
}

class Dog extends Animal{
 public void bark(){} 
}

List<? extends Animal> baseClassList = ...;
Animal animal = baseClassList.get(0)
//if we know animal object is of type Dog then straight away we can cast it
((Dog)animal).bark();

//if we are not sure if it is of Dog type then we have to check its type and if true then cast it and call its methods
if(animal instanceOf Dog){
    ((Dog)animal).bark();
}