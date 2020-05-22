import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Console extends JPanel implements ActionListener
{
    boolean ready = false;
    protected JTextField textField;
    protected JTextArea textArea;
    private final static String newline = "\n";
    //Game m_game;
    Thread t;

    public Console(/*Game game*/) 
    {
        super(new GridBagLayout());

        //m_game = game;
        textField = new JTextField(20);
        textField.setPreferredSize(null);
        textField.addActionListener(this);

        textArea = new JTextArea(20, 60);
        textArea.setEditable(true);
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        Font comic = new Font("Serif", Font.PLAIN, 14);
        textArea.setFont(comic);
        JScrollPane scrollPane = new JScrollPane(textArea);

        //Add Components to this panel.
            // This first object serves as providing values to the TEXTAREA.
        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;

        c.fill = GridBagConstraints.HORIZONTAL;
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0; 
        c.weighty = 0.8;// This being mighty has been given weight as 0.8, the highest.

        // This second object serves as providing values to the TEXTFIELD.
        GridBagConstraints c1 = new GridBagConstraints();
        c1.gridwidth = GridBagConstraints.REMAINDER;

        c1.fill = GridBagConstraints.HORIZONTAL;
        c1.fill = GridBagConstraints.BOTH;
        c1.weightx = 1.0;
        c1.weighty = 0.2;  // Since this has to occupy less space, hence weight is less also.
        add(scrollPane, c);
        add(textField, c1);
    }

    public void actionPerformed(ActionEvent evt) 
    {
        String text = textField.getText();
        //m_game.input = text;
        textField.selectAll();
        textArea.setCaretPosition(textArea.getDocument().getLength());
        //m_game.wait = false;
        /*synchronized (m_game)
        {
            ready = true;
            m_game.notifyAll();
        }*/
    }

    public static void createAndShowGUI() 
    {
        //Create and set up the window.
        JFrame frame = new JFrame("Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add contents to the window.
        frame.setContentPane(new Console());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String... args)
    {
        SwingUtilities.invokeLater(new Runnable()
            {
                public void run()
                {
                    createAndShowGUI();
                }
            });
    }
}