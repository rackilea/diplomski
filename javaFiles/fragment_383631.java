public static void main(String[] args)
{
    if (System.console() != null)
    {
        System.out.println("There is a console!");
    }
    else
    {
        JFrame frame = new JFrame("There is no console!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(100, 100);
        frame.setVisible(true);
    }
}