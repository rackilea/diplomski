import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;

public class Demo {

    private void initGUI(){

        final JToolBar toolBarTop = new JToolBar();
        toolBarTop.add(new JCheckBox("Check 1"));
        toolBarTop.add(new JCheckBox("Check 2"));
        toolBarTop.add(new JCheckBox("Check 3"));

        JButton reset = new JButton("Reset");
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(Component c : toolBarTop.getComponents()){
                    if(c instanceof JCheckBox){
                        JCheckBox checkBox = (JCheckBox) c;
                        checkBox.setSelected(true);
                    }
                }
            }
        });

        toolBarTop.add(reset);

        JPanel content = new JPanel(new FlowLayout());
        content.setPreferredSize(new Dimension(300, 200));
        content.add(toolBarTop);

        JFrame frame = new JFrame("Demo");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setContentPane(content);       
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

}