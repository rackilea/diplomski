import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DialogExample extends JFrame
{
    private JLabel nameLabel;

    public DialogExample()
    {
        super("Dialog Example");
    }

    private void createAndDisplayGUI()
    {       
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPane = new JPanel();
        nameLabel = new JLabel();
        contentPane.add(nameLabel);

        setContentPane(contentPane);
        setSize(200, 100);
        setLocationByPlatform(true);
        setVisible(true);

        MyDialog dialog = new MyDialog(this, "Credentials : ", true);
        dialog.createAndDisplayGUI();
    }

    public void setName(String name)
    {
        if (name.length() > 0)
            nameLabel.setText(name);
        else
            nameLabel.setText("Empty string received.");
    }


    public static void main(String... args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new DialogExample().createAndDisplayGUI();
            }
        });
    }
}

class MyDialog extends JDialog
{
    private JTextField nameField;
    private JFrame frame;

    public MyDialog(JFrame f
            , String title, boolean isModal)
    {
        super(f, title, isModal);
        frame = f;
    }

    public void createAndDisplayGUI()
    {
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        JLabel nameLabel = new JLabel("Please Enter your Name : ");
        nameField = new JTextField(10);
        JButton submitButton = new JButton("SUBMIT");
        submitButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                if (nameField.getDocument().getLength() > 0)
                    frame.setName(nameField.getText());
                else
                    frame.setName("");
                MyDialog.this.dispose();    
            }
        });

        contentPane.add(nameLabel);
        contentPane.add(nameField);
        contentPane.add(submitButton);

        add(contentPane);
        pack();
        setVisible(true);
    }
}