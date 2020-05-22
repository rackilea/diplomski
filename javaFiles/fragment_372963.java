import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.table.*;

public class EachRowEditorExample extends JFrame {

    private static final long serialVersionUID = 1L;

    public EachRowEditorExample() {
        super("EachRow Editor Example");
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                System.out.println(info.getName());
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (UnsupportedLookAndFeelException e) {
            // handle exception
        } catch (ClassNotFoundException e) {
            // handle exception
        } catch (InstantiationException e) {
            // handle exception
        } catch (IllegalAccessException e) {
            // handle exception
        }
        DefaultTableModel dm = new DefaultTableModel();
        dm.setDataVector(new Object[][]{{"Name", "MyName"}, {"Gender", "Male"}, {"Color", "Fruit"}}, new Object[]{"Column1", "Column2"});
        JTable table = new JTable(dm);
        table.setRowHeight(20);
        JComboBox comboBox = new JComboBox();
        comboBox.addItem("Male");
        comboBox.addItem("Female");
        comboBox.addComponentListener(new ComponentAdapter() {

            @Override
            public void componentShown(ComponentEvent e) {
                final JComponent c = (JComponent) e.getSource();
                SwingUtilities.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                        c.requestFocus();
                        System.out.println(c);
                        if (c instanceof JComboBox) {
                            System.out.println("a");
                        }
                    }
                });
            }
        });


        JComboBox comboBox1 = new JComboBox();
        comboBox1.addItem("Name");
        comboBox1.addItem("MyName");
        comboBox1.addComponentListener(new ComponentAdapter() {

            @Override
            public void componentShown(ComponentEvent e) {
                final JComponent c = (JComponent) e.getSource();
                SwingUtilities.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                        c.requestFocus();
                        System.out.println(c);
                        if (c instanceof JComboBox) {
                            System.out.println("a");
                        }
                    }
                });
            }
        });

        JComboBox comboBox2 = new JComboBox();
        comboBox2.addItem("Banana");
        comboBox2.addItem("Apple");
        comboBox2.addComponentListener(new ComponentAdapter() {

            @Override
            public void componentShown(ComponentEvent e) {
                final JComponent c = (JComponent) e.getSource();
                SwingUtilities.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                        c.requestFocus();
                        System.out.println(c);
                        if (c instanceof JComboBox) {
                            System.out.println("a");
                        }
                    }
                });
            }
        });
        EachRowEditor rowEditor = new EachRowEditor(table);
        rowEditor.setEditorAt(0, new DefaultCellEditor(comboBox1));
        rowEditor.setEditorAt(1, new DefaultCellEditor(comboBox));
        rowEditor.setEditorAt(2, new DefaultCellEditor(comboBox2));
        table.getColumn("Column2").setCellEditor(rowEditor);
        JScrollPane scroll = new JScrollPane(table);
        getContentPane().add(scroll, BorderLayout.CENTER);
        setPreferredSize(new Dimension(400, 120));
        setLocation(150, 100);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        EachRowEditorExample frame = new EachRowEditorExample();
        frame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}