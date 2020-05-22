public class Main {



    public static void main(String[] args) {

        Dog dog1 = new Dog("dog1Name", "dog1lname", 5);
        Dog dog2 = new Dog("dog2Name", "dog2lname", 3);
        Cat cat1 = new Cat("cat1Name", "cat1lname", 7);
        Cat cat2 = new Cat("cat2Name", "cat2lname", 1);

        List<Animal> animals = new LinkedList<>();
        animals.add(cat2);
        animals.add(cat1);
        animals.add(dog2);
        animals.add(dog1);

        Collections.sort(animals, new DogCatComparator());
        printList(animals);

        Collections.sort(animals, new SizeComparator());
        printList(animals);

        Collections.sort(animals, new NameComparator());
        printList(animals);
    }


    private static void printList(List<Animal> animals){
        System.out.println("-------------");
        for(Animal animal: animals){
            System.out.println(animal.toString());
        }
    }

}