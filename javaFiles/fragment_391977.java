public class NimGame {

//instantiate scanner object
Scanner scanner = new Scanner(System.in);

private ArrayList<Integer> numbersArray = new ArrayList<>();
private ArrayList<Player> players = new ArrayList<Player>();




public void startGame() {

    fillArrayList(20);
    printArrayListAsCircle();
    //add players
    for (int i = 0; i < 2; i++) {
        System.out.println("Enter name of Player " + (1 + i) + ": ");
        Player player = new Player();
        player.setName(scanner.nextLine());
        players.add(player);
    }

    //run!!!
    while (true) {
        takeTurn(players.get(0));
        if (gameOver() == true) {
            System.out.println(players.get(0) + " lost the game");
            break;
        }
        printArrayListAsCircle();

        takeTurn(players.get(1));
        if (gameOver() == true) {
            System.out.println(players.get(0) + " lost the game");
            break;
        }
        printArrayListAsCircle();

    }
}

private void fillArrayList(int i) {
    //populate arrayList
    for (int j = 1; j <= i; j++) {
        numbersArray.add(j);
    }
}


//worked on this forever, trying (and failing) to implement foreach-loops, while-loops, simple for-loops.
//the result is... not pretty but performs well enough!
//most problems arose with printing the middle part and I must've tried 30 versions until this one worked.
//first I introduce two variables, one 'end'-point and one 'pivot'-point at which to 'wrap' the arraylist around.
//the ascending row is straightforward. run print() on all indices up to but not including the halfwayNumber.
//middle row: i honestly struggle to understand how I arrived there. So much debugging last night I lost it. It works though...
//descending row: analogue to ascending row, run print() on all indices DOWN to the halfwayNumber
public void printArrayListAsCircle() {
    int size = numbersArray.size();
    int halfwayNumber = size / 2;

    int i = 0;
    // Ascending row
    while (i < halfwayNumber-1) {
        print(numbersArray.get(i));
        i++;
    }

    // Middle row
    System.out.println();
    print(numbersArray.get(numbersArray.size()-1));
    for (int j = -1; j < halfwayNumber*2; j++) {
        System.out.print(" ");
    }
    print(numbersArray.get(halfwayNumber-1));
    i = size-2;
    System.out.println();

    // Descending row
    while (i >= halfwayNumber ) {
        print(numbersArray.get(i));
        i--;
    }
    System.out.println();
}

//my print() method. contains some formatting to make the top and bottom row align nicely. at least at the first iteration.
private void print(Integer i) {
    if (i < 10) {
        System.out.print(" " + i + " ");
    } else {
        System.out.print(i + " ");
    }
}

//my new gameOver() method. short and sweet
private boolean gameOver() {
    return numbersArray.size() == 0;
}


//takeTurn() method, changed things around a bit
private void takeTurn(Player player) {
    System.out.println(player + ": please enter a start number");
    int startNumber = Integer.parseInt(scanner.nextLine());
    System.out.println(player + ": please enter an end number");
    int endNumber = Integer.parseInt(scanner.nextLine());
    removeNumbers(startNumber, endNumber);

}

//this took a while and some trial and error, but in the end I came up with an algorithm that works:
//for-loop cycles through the arraylist 'size' times (-> this how often it cycles is dependent on the flexible size of the arraylist)...
// ...and for each iteration increments i to arrive at the next index UNLESS...
//...it finds an index where both if-conditions are found to be true. then i is removed.
//To ensure that ALL numbers in between startNum and endNum are removed as well i is then decremented...
//... because of the arraylist shrinking and assigning new indices to the elements 'shuffled to the left'.
private void removeNumbers(int startNumber, int endNumber) {
    for (int i = 0; i < numbersArray.size(); i++) {
        if (numbersArray.get(i) >= startNumber && numbersArray.get(i) <= endNumber) {
            numbersArray.remove(i);
            i--;
        }
    }
}
}