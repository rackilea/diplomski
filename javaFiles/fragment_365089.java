import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class Window extends Thread
{
    private static JFrame window = new JFrame("game");
    private int numberSquareX = Settings.sizeX / 20 + 1;
    private int numberSquareY = Settings.sizeY / 20 + 1;
    private JLabel titlesetLayer1[][] = new JLabel[numberSquareX][numberSquareY];
    private JLabel titlesetLayer2[] = new JLabel[1];
    private JLabel titlesetLayer3[] = new JLabel[1];
    private JLabel titlesetLayer4[] = new JLabel[0];
    private JLabel titlesetLayer5[] = new JLabel[0];
    private JLabel characters[] = new JLabel[2];

    public void run()
    {
        window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        window.setSize(Settings.sizeX, Settings.sizeY);
        window.setLocationRelativeTo(null);
        window.setResizable(false);

        // draw layer5 (on the layer4)

        // draw layer4 (on the layer3)

        // draw layer3 (on the characters)
        titlesetLayer3[0] = new JLabel(new ImageIcon("tree_1.png"));
        titlesetLayer3[0].setBounds(130, 120, 126, 160);
        window.add(titlesetLayer3[0]);

        // draw the charaters
        characters[1] = new JLabel(new ImageIcon("character_1.png"));
        characters[1].setBounds(600, 500, 100, 100);
        window.add(characters[1]);

        characters[0] = new JLabel(new ImageIcon("character_1.png"));
        characters[0].setBounds(100, 100, 100, 100);
        window.add(characters[0]);

        // draw layer2 (under the characters)
        titlesetLayer2[0] = new JLabel(new ImageIcon("tree_1.png"));
        titlesetLayer2[0].setBounds(570, 400, 126, 160);
        window.add(titlesetLayer2[0]);

        // draw layer1 (under the layer2)
        for (int x = 0, y = 0; y < numberSquareY; x++)
        {
            titlesetLayer1[x][y] = new JLabel(new ImageIcon("grass_1.png"));
            titlesetLayer1[x][y].setBounds(x * 20, y * 20, 20, 20);
            window.add(titlesetLayer1[x][y]);
            if (x == numberSquareX - 1)
            {
                y++;
                x = -1;
            }
        }
        titlesetLayer1[numberSquareX - 1][numberSquareY - 1] = new JLabel(new ImageIcon("grass_1.png"));
        titlesetLayer1[numberSquareX - 1][numberSquareY - 1].setBounds(numberSquareX * 20, numberSquareY * 20, 20, 20);
        window.add(titlesetLayer1[numberSquareX - 1][numberSquareY - 1]);

        window.setVisible(true);
        // window.repaint();
    }
}