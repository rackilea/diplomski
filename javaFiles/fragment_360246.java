public class MyArrayListTest {

static MyArrayList zoo = new MyArrayList();


public static void printZoo() {
    System.out.print("The zoo now holds " + zoo.getArraySize() + " animals: ");
    for (int j = 0; j < zoo.getArraySize(); j++) System.out.print(zoo.get(j) + " ");
    System.out.println();
}

public static void main(String[] args) {

    System.out.println("Testing constructor, add(object) and size() ");
    zoo.add("Ant");
    zoo.add("Bison");
    zoo.add("Camel");
    zoo.add("Dog");
    zoo.add("Elephant");
    zoo.add("Frog");
    zoo.add("Giraffe");
    zoo.add("Horse");
    printZoo();
    System.out.println();
}
 }