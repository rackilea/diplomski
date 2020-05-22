import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class WindowBuilderTest extends JFrame
{

    private JPanel  contentPane;

//Launch the application.
    public static void main(final String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    final WindowBuilderTest frame = new WindowBuilderTest();
                    frame.setVisible(true);
                }
                catch (final Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
    }

    // Creating Frame
    public WindowBuilderTest()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1280, 720);
        this.contentPane = new JPanel();
        this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(this.contentPane);
        this.contentPane.setLayout(null);

        // Create Font
        final Font headfont = new Font("Serif", Font.PLAIN, 15);

        // Role Headlines
        final JTextArea txtTop = new JTextArea();
        txtTop.setEditable(false);
        txtTop.setText("TOP");
        txtTop.setBounds(180, 95, 32, 23);
        txtTop.setFont(headfont);
        this.contentPane.add(txtTop);

        final JTextArea txtMid = new JTextArea();
        txtMid.setEditable(false);
        txtMid.setText("MID");
        txtMid.setBounds(252, 95, 32, 23);
        this.contentPane.add(txtMid);

        final JTextArea txtJng = new JTextArea();
        txtJng.setEditable(false);
        txtJng.setText("JNG");
        txtJng.setBounds(320, 95, 32, 23);
        this.contentPane.add(txtJng);

        final JTextArea txtAdc = new JTextArea();
        txtAdc.setEditable(false);
        txtAdc.setText("ADC");
        txtAdc.setBounds(389, 95, 32, 23);
        this.contentPane.add(txtAdc);

        final JTextArea txtSup = new JTextArea();
        txtSup.setEditable(false);
        txtSup.setText("SUP");
        txtSup.setBounds(453, 95, 32, 23);
        this.contentPane.add(txtSup);

        // Checkbox 1st row
        addCheckBox(183, 143, 23, 23, txtTop);
        addCheckBox(255, 143, 23, 23, txtMid);
        addCheckBox(322, 143, 23, 23, txtJng);
        addCheckBox(393, 143, 23, 23, txtAdc);
        addCheckBox(457, 143, 23, 23, txtSup);
    }

    private void addCheckBox(final int x, final int y, final int width, final int height, final JTextArea txtTop)
    {
        final JCheckBox checkBox = new JCheckBox();
        checkBox.setBounds(x, y, width, height);
        checkBox.addItemListener(new BoldChanger(txtTop));
        this.contentPane.add(checkBox);
    }

    class BoldChanger implements ItemListener
    {
        private JTextArea   textArea;

        public BoldChanger(final JTextArea textArea)
        {
            this.textArea = textArea;
        }

        @Override
        public void itemStateChanged(final ItemEvent e)
        {
            if (e.getStateChange() == ItemEvent.SELECTED)
            {
                final Font boldFont = this.textArea.getFont().deriveFont(Font.BOLD);
                this.textArea.setForeground(Color.RED);
                this.textArea.setFont(boldFont);
            }
            else
            {
                final Font boldFont = this.textArea.getFont().deriveFont(Font.PLAIN);
                this.textArea.setForeground(Color.BLACK);
                this.textArea.setFont(boldFont);
            }
        }
    }
}