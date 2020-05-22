public class Main {

    public static void main(String[] args) {
        int pixel = -16777216;

        int alpha = (pixel >> 24) & 0xff;
        int red   = (pixel >> 16) & 0xff;
        int green = (pixel >>  8) & 0xff;
        int blue  = (pixel      ) & 0xff;

        System.out.println(alpha);
        System.out.println(red);
        System.out.println(green);
        System.out.println(blue);


    }
}