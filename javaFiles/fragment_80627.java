public class Paneel extends JPanel 
{
    public Paneel() {

    }

    public void printSizes() {
        int width = getWidth();
        int height = getHeight();

        System.out.println(width);
        System.out.println(height);
    }
}