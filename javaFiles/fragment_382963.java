import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;

public class BottomPanel extends JPanel {
    /* instead of strings, added references to JButtons
     * so that they can be accessed from other classes
     */
    public JButton findbtn;
    public JButton insertBtn;
    public JButton updateBtn;
    public JButton deleteBtn;
    public JButton exitBtn;

    public BottomPanel() {
        findbtn=new JButton("Find");
        add(findbtn);

        insertBtn=new JButton("Insert");
        add(insertBtn);

        updateBtn=new JButton("Update");
        add(updateBtn);

        deleteBtn=new JButton("Delete");
        add(deleteBtn);

        exitBtn=new JButton("Exit");
        add(exitBtn);
    }
}