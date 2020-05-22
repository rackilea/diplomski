public class JGAME
{
    static JFrame window = new JFrame("Gun Them Down");
    static BufferedImage myImage;

    private static void CreateMenuWindow()
    {
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(600, 600);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setVisible(true);
    }

    public static void main(String[] args) throws IOException
    {   
        myImage = ImageIO.read(new File("D:\\STEFANO\\Progetti Java\\JGAME\\src\\resources\\Pacman.png"));

        JPanel background = new JPanel()
        {
            @Override
            protected void paintComponent(Graphics g)
            {
                super.paintComponent(g);
                g.drawImage(myImage, 0, 0, null);
            }
        };

       window.add(background);
       CreateMenuWindow();
    }
}