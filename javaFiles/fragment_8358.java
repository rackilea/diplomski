//Static function that return the number of times it has been called
public static returnNumber() {
    final int i=1;
    return i++;
 }

public static void main() {
    int a = returnNumber(); //Initialize a
    for (j=0; j<10; j++) {
        System.out.println(a); //print the current value of a
    }
}