import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class SSCCE
{
    private final int WIDTH = 500;
    private final int HEIGHT = 500;
    private CustomPanel customPanel;
    private JButton circleButton;
    private JTextField tfield;
    private Random random;
    private int mode;

    private Action paintAction = new AbstractAction()
    {
        @Override
        public void actionPerformed(ActionEvent ae)
        {
            mode = random.nextInt(3);
            Color color = new Color(random.nextFloat(), random.nextFloat()
                                                        , random.nextFloat(), random.nextFloat());
            customPanel.setValues(random.nextInt(WIDTH), 
                            random.nextInt(HEIGHT), random.nextInt(WIDTH), 
                                                                    random.nextInt(HEIGHT), color, mode);
        }
    };

    private ActionListener buttonAction = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent ae)
        {
            Color color = new Color(random.nextFloat(), random.nextFloat()
                                                        , random.nextFloat(), random.nextFloat());
            customPanel.setValues(random.nextInt(WIDTH), 
                            random.nextInt(HEIGHT), random.nextInt(WIDTH), 
                                                                    random.nextInt(HEIGHT), color, 2);
        }
    };

    public SSCCE()
    {
        random = new Random();
    }

    private void displayGUI()
    {
        JFrame frame = new JFrame("SSCCE");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout(5, 5));

        customPanel = new CustomPanel();
        customPanel.getInputMap(
            JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_D
                    , InputEvent.CTRL_DOWN_MASK), "paintAction");
        customPanel.getActionMap().put("paintAction", paintAction);

        JPanel footerPanel = new JPanel();
        circleButton = new JButton("Draw Circle");
        circleButton.setMnemonic(KeyEvent.VK_C);
        circleButton.addActionListener(buttonAction);

        tfield = new JTextField(20);
        tfield.setText("USELESS, just to get the focus for itself.");
        tfield.requestFocusInWindow();
        footerPanel.add(tfield);
        footerPanel.add(circleButton);

        contentPane.add(customPanel, BorderLayout.CENTER);
        contentPane.add(footerPanel, BorderLayout.PAGE_END);

        frame.setContentPane(contentPane);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String... args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                new SSCCE().displayGUI();
            }
        });
    }
}

class CustomPanel extends JPanel
{
    private final int WIDTH = 500;
    private final int HEIGHT = 500;
    private int mode = 0;
    private Color colorShape;
    private int x = 0;
    private int y = 0;
    private int width = 0;
    private int height = 0;

    public void setValues(int x, int y, int w, int h, Color color, int mode)
    {
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
        this.colorShape = color;
        this.mode = mode;

        repaint();
    }

    @Override
    public Dimension getPreferredSize()
    {
        return (new Dimension(WIDTH, HEIGHT));
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(colorShape);
        if (mode == 1)
            g.fillRect(x, y, width, height);
        else if (mode == 2)
            g.fillOval(x, y, width, height);
    }
}