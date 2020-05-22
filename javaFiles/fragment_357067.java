import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;


@SuppressWarnings("serial")
public class MainFrame extends JFrame
{
    private JTextField txt;
    private PopUpKeyboard keyboard;

    public MainFrame()
    {
        super("pop-up keyboard");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        txt = new JTextField(20);
        keyboard = new PopUpKeyboard(txt);

        txt.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                Point p = txt.getLocationOnScreen();
                p.y += 30;
                keyboard.setLocation(p);
                keyboard.setVisible(true);
            }
        });
        setLayout(new FlowLayout());
        add(txt);

        pack();
        setLocationByPlatform(true);
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                new MainFrame().setVisible(true);
            }
        });
    }

    private class PopUpKeyboard extends JDialog implements ActionListener
    {
        private JTextField txt;

        public PopUpKeyboard(JTextField txt)
        {
            this.txt = txt;
            setLayout(new GridLayout(3, 3));
            for(int i = 1; i <= 9; i++) createButton(Integer.toString(i));
            pack();
        }

        private void createButton(String label)
        {
            JButton btn = new JButton(label);
            btn.addActionListener(this);
            btn.setFocusPainted(false);
            btn.setPreferredSize(new Dimension(100, 100));
            Font font = btn.getFont();
            float size = font.getSize() + 15.0f;
            btn.setFont(font.deriveFont(size));
            add(btn);
        }

        @Override
        public void actionPerformed(ActionEvent e)
        {
            String actionCommand = e.getActionCommand();
            txt.setText(txt.getText() + actionCommand);
        }
    }
}