import java.awt.BorderLayout;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import net.miginfocom.swing.MigLayout;

public class Demo {    

    private void initGUI() {        
        JPanel top = new JPanel();
        top.setLayout(new MigLayout("","",""));

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        JLabel dateTime = new JLabel(dateFormat.format(new Date()));

        top.add(dateTime, "wrap");
        top.add(new JButton("Inventory"));
        top.add(new JButton("Transaction"));
        top.add(new JButton("Add Item"));

        JFrame frame = new JFrame("Demo");
        frame.add(top,BorderLayout.NORTH);        
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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