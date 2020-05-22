import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.*;

public class LabelIconGridUI extends LayerUI<JComponent>
{
    @Override
    public void paint(Graphics g, JComponent c)
    {
        super.paint(g, c);

        Graphics2D g2 = (Graphics2D) g.create();
        g2.setColor( Color.ORANGE );

        JLayer jlayer = (JLayer)c;
        JLabel label = (JLabel)jlayer.getView();

        Rectangle viewR = new Rectangle();
        viewR.width = label.getSize().width;
        viewR.height = label.getSize().height;
        Rectangle iconR = new Rectangle();
        Rectangle textR = new Rectangle();

        String clippedText = SwingUtilities.layoutCompoundLabel
        (
            label,
            g2.getFontMetrics(),
            label.getText(),
            label.getIcon(),
            label.getVerticalAlignment(),
            label.getHorizontalAlignment(),
            label.getVerticalTextPosition(),
            label.getHorizontalTextPosition(),
            viewR,
            iconR,
            textR,
            label.getIconTextGap()
        );

        int gridSize = 10;
        int start = iconR.x + gridSize;
        int end = iconR.x + iconR.width;

        for (int i = start; i < end; i += gridSize)
        {
            g2.drawLine(i, iconR.y, i, iconR.y + iconR.height);
        }

        g2.dispose();
    }

    private static void createAndShowUI()
    {
        JLabel label = new JLabel("Some Text" );
        label.setIcon( new ImageIcon( "DukeWaveRed.gif" ) );

        label.setVerticalAlignment( JLabel.CENTER );
        label.setHorizontalAlignment( JLabel.CENTER );
        label.setVerticalTextPosition( JLabel.BOTTOM );
        label.setHorizontalTextPosition( JLabel.CENTER );

        LayerUI<JComponent> layerUI = new LabelIconGridUI();
        JLayer<JComponent> layer = new JLayer<JComponent>(label, layerUI);

        JFrame frame = new JFrame("Label Icon Grid");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add( layer );
        frame.pack();
        frame.setLocationByPlatform( true );
        frame.setVisible( true );
    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                createAndShowUI();
            }
        });
    }
}