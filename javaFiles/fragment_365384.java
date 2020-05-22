private static Class[] animalTypes = [Dog.class, Cat.class];

public static String identifyAnimal(String animalSound)
{
    for (int i = 0; i < animalTypes.length; i++) {
        Animal a = animalTypes[i].newInstance();
        String s = a.produceSound();

        if (animalSound.equals(s))
            return animalTypes[i].getName();
    }

    return null;
}