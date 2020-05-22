import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.UIManager;


public class Demo {    
    /* 
     * This variable will point to a pressed button to keep reference.
     */
    JButton _alreadyPressedButton = null;

    /**
     * Initializes the GUI
     */
    private void initGUI(){
        /*
         * Create needed icons - As this example uses 6 buttons, then I need 3 icons 
         */
        ImageIcon icon1 = (ImageIcon) UIManager.getIcon("OptionPane.errorIcon");
        ImageIcon icon2 = (ImageIcon) UIManager.getIcon("OptionPane.informationIcon");
        ImageIcon icon3 = (ImageIcon) UIManager.getIcon("OptionPane.warningIcon");
        /*
         * Make a list with 6 icons (add each icon twice)
         */
        List<ImageIcon> iconsList = new ArrayList<>();
        iconsList.add(icon1);
        iconsList.add(icon1);
        iconsList.add(icon2);
        iconsList.add(icon2);
        iconsList.add(icon3);
        iconsList.add(icon3);
        Collections.shuffle(iconsList); /* Shuffle the list */

        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(e.getSource() instanceof JButton){                    
                    final JButton pressedButton = (JButton) e.getSource();              
                    /* 
                     * Execute this code in a SwingWorker to prevent block EDT at "Thread.sleep(500)" line
                     * Google for EDT (Event Dispatch Thread)
                     */
                    SwingWorker sw = new SwingWorker() {
                        @Override
                        protected Object doInBackground() throws Exception {
                            if(_alreadyPressedButton != pressedButton){
                                pressedButton.setIcon(pressedButton.getPressedIcon());

                                if(_alreadyPressedButton != null){ 
                                    Thread.sleep(500);
                                    if(_alreadyPressedButton.getIcon() == pressedButton.getIcon()){
                                        _alreadyPressedButton.setEnabled(false);
                                        pressedButton.setEnabled(false);
                                    } else {
                                        _alreadyPressedButton.setIcon(null);
                                        pressedButton.setIcon(null);
                                    }
                                    _alreadyPressedButton = null;
                                } else {
                                    _alreadyPressedButton = pressedButton;
                                }

                            }
                            return null;
                        }

                    };

                    sw.execute();
                }
            }
        };

        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.setPreferredSize(new Dimension(200, 200));

        for(ImageIcon icon : iconsList){
            JButton button = new JButton();
            button.setPressedIcon(icon);
            button.addActionListener(actionListener);
            panel.add(button);
        }

        JFrame frame = new JFrame("Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                 new Demo().initGUI();
            }
        });        

    }
}