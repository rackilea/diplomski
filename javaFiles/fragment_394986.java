public class TwoDice2 {
public static void main(String[ ] args) {

Die firstDie = new Die( );
Die secondDie = new Die( );

if (firstDie.getValue() == secondDie.getValue()) {
System.out.println("First die is " + firstDie.getValue( ));
System.out.println("Next die is " + secondDie.getValue( ));
System.out.println("The two dice are the same!");
}

    if (firstDie.getValue() > secondDie.getValue()) {
        System.out.println("First die is " + firstDie.getValue( ));
        System.out.println("Next die is " + secondDie.getValue( ));
        System.out.println("Die One: " + firstDie.getValue() + " is greater than Die Two: " + secondDie.getValue());
    }
        if (firstDie.getValue() < secondDie.getValue()) {
            System.out.println("First die is " + firstDie.getValue( ));
            System.out.println("Next die is " + secondDie.getValue( ));
            System.out.println("Die One: " + firstDie.getValue() + " is less than Die Two: " + secondDie.getValue());
        }

}