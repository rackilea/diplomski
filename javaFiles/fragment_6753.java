public class Test
{
     public static void main(String[] args)
     {
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setSize(600, 600);

        // By passing the frame as a reference, the function
        // will be able to add the button to this frame.
        Test2.addButton(frame);
    }
}