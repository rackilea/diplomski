public class Main {
    ArrayList<Monster> myMonsters = new ArrayList<Monster>();

public Main() {
    Monster yetti = new Monster("Yetti", "The Mountains", 77);
    Monster lochness = new Monster("Lochness Monster", "Scotland", 20);

    myMonsters.add(yetti); // <-- added Yetti to our list
    myMonsters.add(lochness); // <--added Lochness to our list

    for (Monster m : myMonsters) {
        m.printDetails();
     }
   }

public static void main(String[] args) {
    new Main();
 }
}