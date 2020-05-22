import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class Demo {

    private void initGUI(){
        JScrollPane scrollPane = new JScrollPane(new JTextArea(10, 20));
        scrollPane.getHorizontalScrollBar().setUI(new MyScrollbarUI());
        scrollPane.getVerticalScrollBar().setUI(new MyScrollbarUI());

        JFrame frame = new JFrame("Demo");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(scrollPane);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Demo().initGUI();
            }
        });
    }

    class MyScrollbarUI extends BasicScrollBarUI {

        private ImageIcon downArrow, upArrow, leftArrow, rightArrow;

        public MyScrollbarUI(){
            try {
                upArrow = new ImageIcon(new java.net.URL("http://icons.iconarchive.com/icons/oxygen-icons.org/oxygen/16/Actions-arrow-up-icon.png"));
                downArrow = new ImageIcon(new java.net.URL("http://icons.iconarchive.com/icons/oxygen-icons.org/oxygen/16/Actions-arrow-down-icon.png"));
                rightArrow = new ImageIcon(new java.net.URL("http://icons.iconarchive.com/icons/oxygen-icons.org/oxygen/16/Actions-arrow-right-icon.png"));
                leftArrow = new ImageIcon(new java.net.URL("http://icons.iconarchive.com/icons/oxygen-icons.org/oxygen/16/Actions-arrow-left-icon.png"));
            } catch (java.net.MalformedURLException ex) {
                ex.printStackTrace();
            }        
        }

        @Override
        protected JButton createDecreaseButton(int orientation) {
            JButton decreaseButton = new JButton(getAppropriateIcon(orientation)){
                @Override
                public Dimension getPreferredSize() {
                    return new Dimension(22, 22);
                }
            };
            return decreaseButton;
        }

        @Override
        protected JButton createIncreaseButton(int orientation) {
            JButton increaseButton = new JButton(getAppropriateIcon(orientation)){
                @Override
                public Dimension getPreferredSize() {
                    return new Dimension(22, 22);
                }
            };
            return increaseButton;
        }

        private ImageIcon getAppropriateIcon(int orientation){
            switch(orientation){
                case SwingConstants.SOUTH: return downArrow;
                case SwingConstants.NORTH: return upArrow;
                case SwingConstants.EAST: return rightArrow;
                    default: return leftArrow;
            }
        }
    }    

}