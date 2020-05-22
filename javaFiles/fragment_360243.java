import java.awt.EventQueue;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;


public class MigLayoutDemo4 extends JFrame {

    private static final int CELL_WIDTH = 60;
    private static final int CELL_HEIGHT = 50;

    public MigLayoutDemo4() {

        initUI();
    }

    private void initUI() {

        JPanel pnl = new JPanel(new MigLayout("gap 0 0"));


        pnl.add(createLabel("One"), "pos 0 0"); 
        pnl.add(createLabel("Two"), "pos "+(CELL_WIDTH * 3)+" "+(CELL_HEIGHT * 0));
        pnl.add(createLabel("Three"), "pos "+(CELL_WIDTH * 6)+" "+(CELL_HEIGHT * 0));
        pnl.add(createLabel("Four"), "pos "+(CELL_WIDTH * 6)+" "+(CELL_HEIGHT * 1));
        pnl.add(createLabel("Five"), "pos "+(CELL_WIDTH * 0)+" "+(CELL_HEIGHT * 2));
        pnl.add(createLabel("Six"),"pos "+(CELL_WIDTH * 2)+" "+(CELL_HEIGHT * 2));       
        pnl.add(createLabel("Seven"), "pos "+(CELL_WIDTH * 5)+" "+(CELL_HEIGHT * 2));

        add(pnl);
        pack();

        setTitle("MigLayout example");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
    }

    private JLabel createLabel(String text) {

        JLabel lbl = new JLabel(text, JLabel.CENTER);
        lbl.setBorder(BorderFactory.createEtchedBorder());

        return lbl;

    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MigLayoutDemo3 ex = new MigLayoutDemo3();
                ex.setVisible(true);
            }
        });       
    }
}