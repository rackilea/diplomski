public void feed(Pet pet, int foodAmount){
        pet.feed(foodAmount);
}

public class Pet{       
}

public class Dog extends Pet{
    public void feed(int foodAmount){
        // feed like a dog
    }
}


public class Cat extends Pet{
    public void feed(int foodAmount){
        // feed like a cat
    }
}