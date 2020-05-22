public class printPi
{

    public static void main(String[] args)
    {   
        double pi = 3.14159265359;
        piPrinter(pi);
    }
    public static void piPrinter(double pi01)
    {

        if ((int) pi01 != 0) {

            System.out.println((int) pi01 * 2);
            piPrinter((pi01 - (int) pi01) * 10);

        } else {
            System.out.println("done.");
        }

    }
}