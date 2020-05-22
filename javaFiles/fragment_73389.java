import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Test {
    public static void main(String[] args) {
        MainWindow mainWindow = new MainWindow();
        mainWindow.setVisible(true);
    }
}

class MainWindow extends JFrame{

    private static final long serialVersionUID = 679207429168581441L;
    //
    private static final int FRAME_WIDTH = 800;
    private static final int FRAME_HEIGHT = 600;
    private String nameFromModal;
    //
    private ModalDialog dialog;

    public MainWindow() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(dim.width/2-FRAME_WIDTH/2, dim.height/2-FRAME_HEIGHT/2, FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //
        JButton clickMe = new JButton("Open Modal Dialog!");
        clickMe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog = new ModalDialog(MainWindow.this);
                dialog.setVisible(true);
                JOptionPane.showMessageDialog(MainWindow.this, "Name From Modal Dialog: "+MainWindow.this.getNameFromModal());
            }
        });
        //
        JPanel p = new JPanel(new FlowLayout());
        p.add(clickMe);
        MainWindow.this.add(p, BorderLayout.NORTH);
    }

    public void setValuesOfModalDialog(String name){
        this.nameFromModal = name;
    }

    public String getNameFromModal() {
        return nameFromModal;
    }
}

class ModalDialog extends JDialog{
    private static final int FRAME_WIDTH = 300;
    private static final int FRAME_HEIGHT = 300;
    private MainWindow parentWindow;
    private JTextField nameField;

    public ModalDialog(MainWindow parentWindow) {
        super(parentWindow);
        this.parentWindow = parentWindow;
        //
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(dim.width/2-FRAME_WIDTH/2, dim.height/2-FRAME_HEIGHT/2, FRAME_WIDTH, FRAME_HEIGHT);
        setModal(true);
        //
        setLayout(new FlowLayout());
        //
        JLabel nameLabel = new JLabel("Name: ");
        add(nameLabel);
        nameField = new JTextField();
        nameField.setPreferredSize(new Dimension(100, 25));
        add(nameField);
        //
        JButton submit = new JButton("Submit!");
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parentWindow.setValuesOfModalDialog(nameField.getText());
                ModalDialog.this.dispose();
            }
        });
        //
        add(submit);
    }
}