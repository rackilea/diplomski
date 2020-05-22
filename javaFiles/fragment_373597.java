public enum Animal {
    RABBIT( Food.HERBIVORE ) , 
    DOG( Food.OMNIVORE ) , 
    CAT( Food.CARNIVORE ) ;  

    // Member variables.
    public Food eats ; 

    // Constructor
    Animal( Food foodType ) {
        this.eats = foodType ;  // Assign an instance of another enum to this instance of this enum.
    }

}