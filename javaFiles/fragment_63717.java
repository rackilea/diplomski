public class testing extends Applet {
    private String message = "";

    public static void main(String[]args)throws IOException
    {
        JFrame jp1 = new JFrame();
        testing a =new testing ();
        // ..
        a.message = "Hello";
        // ..
    }

    public void paint (Graphics g) {
        g.drawString(message,40,30);
    }
}