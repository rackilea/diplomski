import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class InternalFrameTest extends JPanel
{
    private static final long serialVersionUID = 1L;
    private JInternalFrame internalFrame;
    public InternalFrameTest()
    {
        this.internalFrame = new JInternalFrame("Internal frame");
        internalFrame.setLayout(new FlowLayout());
        internalFrame.add(new JLabel("I am label"));
        internalFrame.add(new JButton("Oi button"));    
        internalFrame.pack();
        add(internalFrame);
    }

    public void showHideInternalFrame()
    {
        internalFrame.setVisible(!internalFrame.isVisible());
    }
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {               
                final InternalFrameTest ift = new InternalFrameTest();
                ift.setBackground(Color.GREEN);
                JFrame f = new JFrame();
                f.addMouseListener(new MouseAdapter() 
                {
                    @Override
                    public void mousePressed(MouseEvent e)
                    {
                        super.mousePressed(e);
                        ift.showHideInternalFrame();
                    }                   
                });
                JPanel cp = new JPanel(new BorderLayout());
                cp.add(ift);
                JPanel eastP = new JPanel();
                eastP.add(new JLabel("EAST"));
                eastP.setBackground(Color.YELLOW);
                cp.add(eastP, BorderLayout.EAST);
                f.setContentPane(cp);
                f.setSize(400, 300);
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setVisible(true);
            }
        });
    }
}