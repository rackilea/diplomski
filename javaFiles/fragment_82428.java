public class HelloWorld {

    public static void main(String[] args) {
        final int IMAX= 15, JMAX=10;

        System.out.print("   |");
        for (int i = 1; i <= JMAX; i++) {
            System.out.printf("%-4d", i);
        }
        System.out.println();
        System.out.print("--------------------------------------------------------" );
        System.out.println();

        for (int i = 1; i <= IMAX; i++) {
            System.out.printf("%-3d|", i);
            for (int j = 1; j <= i && j <=JMAX; j++) {
                System.out.printf("%-4d", i*j);
            }
            System.out.println();
        }

    } 

}