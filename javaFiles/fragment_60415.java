public class PlotPoints {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PlotPoints pp = new PlotPoints();
        pp.plotPoints(sc);
    }
    public void plotPoints(Scanner keyboard)
    {
        int x=1;
        while (x != -1) {

            System.out.print("Enter an x and y coordinate: ");


            //Read x from user
            x = keyboard.nextInt();

            //Read y from user
            int y = keyboard.nextInt();

            //Plot the point
            new Circle(x, y);
        }
    }
}