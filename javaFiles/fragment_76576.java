public static IAnimal copyAnimal(IAnimal animal) {
    if (animal instanceof Dog)
        return copyDog((Dog) animal);
    if (animal instanceof Cat)
        return copyCat((Cat) animal);
    //...
    else
        throw new IllegalArgumentException("Could not copy animal of type: "
                + animal.getClass().getName());
}