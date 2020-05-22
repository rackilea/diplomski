import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;

public class ShowTable extends JFrame {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            startApp();
        });

    }

    static void startApp(){
        JFrame frame = new JFrame();


        DefaultTableModel model = new DefaultTableModel(0, 1);
        JTable table = new JTable(model);
        frame.getContentPane().add(new JScrollPane(table));

        frame.setSize(new Dimension(800, 600));
        frame.setVisible(true);

        new Thread(){
            @Override
            public void run() {
                while(true) {
                    SwingUtilities.invokeLater(() -> {
                        model.addRow(new Object[]{"some data"});

                    });
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}