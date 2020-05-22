public class Euler {

/**
 * @param args the command line arguments
 */
public static void main(String[] args) {
    long a1 = 1; //smallest 
    long a2 = 1;
    long a3 = 1;
    long a4 = 1;  //greatest
    boolean isSolved = false;
    double a6 = 0;
    double a7 = 0;
    long a8 = 0;
    double a9 = 0;
    while (!isSolved) {
        a1++;
        if (a1 > a2) {
            a2++;
            a1 = 1;
        }
        if (a2 > a3) {
            a3++;
            a2 = 1;
            a1 = 1;
        }
        if (a3 > a4) { 
            //System.out.println(a4 + " " + isSolved);
            a4++;
            a3 = 1;
            a2 = 1;
            a1 = 1;
        }
        a6 = Math.pow(a1, 5) + Math.pow(a2, 5) + Math.pow(a3, 5) + Math.pow(a4, 5);
        a7 = Math.pow(a6, 0.2);

        a8 = (long) a7;
        a9 = Math.pow(a8, 5);

        if (a6 == a9) {
            isSolved = true;
            System.out.println(a1 + " " + a2 + " " + a3 + " " + a4 + " " + a8);
        }           
    }
}
}