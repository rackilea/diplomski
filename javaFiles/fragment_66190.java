import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Window {

    private final JFrame frame;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Window window = new Window();
            window.frame.setVisible(true);

        });
    }

    public Window() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        initialize();
    }

    public void initialize() {
        //Creating the Panel for Menu Bar       
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 434, 23);
        frame.getContentPane().add(panel);
        panel.setLayout(new BorderLayout(0, 0));
        //Creating the Menu File Bar
        JMenuBar bar = new JMenuBar();
        panel.add(bar, BorderLayout.NORTH);
        JMenu file = new JMenu("File");
        JMenuItem load = new JMenuItem("Load");
        JMenuItem save = new JMenuItem("Save");
        JMenuItem exit = new JMenuItem("Exit");
        file.add(load);
        file.add(save);
        file.add(exit);
        bar.add(file);

        //Populate Left List with part names    
        final DefaultListModel parts = new DefaultListModel();
        parts.addElement("Case");
        parts.addElement("Motherboard");
        parts.addElement("CPU");
        parts.addElement("GPU");
        parts.addElement("PSU");
        parts.addElement("RAM");
        parts.addElement("HDD");

        final JList leftList = new JList(parts);
        leftList.setBounds(10, 26, 142, 224);
        frame.getContentPane().add(leftList);

        //create right list 
        final DefaultListModel partSelected = new DefaultListModel();
        final JList rightList = new JList(partSelected);
        rightList.setBounds(282, 26, 142, 224);
        frame.getContentPane().add(rightList);

        //add event to the button to move items from left list to right list
        JButton btnNewButton = new JButton(">>");
        btnNewButton.addActionListener((ActionEvent arg0) -> {
//            rightList.setListData((Vector) leftList.getSelectedValue());
            for (Object selectedValue : leftList.getSelectedValuesList()) {
                partSelected.addElement(selectedValue);
                parts.removeElement(selectedValue);
                int iSelected = leftList.getSelectedIndex();
                if (iSelected == -1) {
                    return;
                }
            }
        });
        btnNewButton.setBounds(172, 86, 89, 23);
        frame.getContentPane().add(btnNewButton);

        //Remove Button     
        JButton remove = new JButton("<<");
        remove.addActionListener((ActionEvent arg0) -> {
//            rightList.setListData(leftList.getSelectedValues());
            for (Object selectedValue : rightList.getSelectedValuesList()) {
                parts.addElement(selectedValue);
                partSelected.removeElement(selectedValue);
                int selected = rightList.getSelectedIndex();
                if (selected == -1) {
                    return;
                }
            }
        });
        remove.setBounds(172, 140, 89, 23);
        frame.getContentPane().add(remove);
    }
}