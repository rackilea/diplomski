package randp;


public class Main {

    public static void main(String[] args) {
        Randp randp = new Randp(10);
        for (int i = 0; i < 10; i++) {
            System.out.print(randp.nextInt());
        }
    } 

}


package randp;

public class Randp {

private int numsLeft;
private int MAX_VALUE;
int[] chooser;

public Randp(int startCounter) {
    MAX_VALUE = startCounter; //set the amount we go up to
    numsLeft = startCounter;
    chooser = new int[MAX_VALUE];
    for (int i = 1; i <= chooser.length; i++) {
        chooser[i-1] = i; //fill the array up

    }
}

public int nextInt() {
    if(numsLeft == 0){
        return 0; //nothing left in the array
    }
    int a = chooser[(int)(Math.random() * MAX_VALUE)]; //picking a random index
    if(a == 0) {
        return this.nextInt(); //we hit an index that's been used already, pick another one!
    }
    chooser[a-1] = 0; //don't want to use it again
    numsLeft--; //keep track of the numbers
    return a;

}
}