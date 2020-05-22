import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.util.Random;

public class VerticalTextFields {

    private JComponent ui = null;

    VerticalTextFields() {
        initUI();
    }

    public void initUI() {
        if (ui!=null) return;

        ui = new JPanel(new BorderLayout(4,4));
        ui.setBorder(new EmptyBorder(4,20,4,20));

        Random r = new Random();
        int n = 10 + r.nextInt(10);
        JPanel textFieldContainer = new JPanel(new GridLayout(0, 1, 5, 5));
        /*
        While I do not see the point of this array, you may have 
        some purpose for it that is not immediately obvious, so..
        */
        JTextField[] textFieldArray = new JTextField[n];
        for (int ii=0; ii<n; ii++) {
            textFieldArray[ii] = new JTextField("Text field " + (ii+1), 40);
            textFieldContainer.add(textFieldArray[ii]);
        }
        JScrollPane textFieldScrollPane = new JScrollPane(textFieldContainer);
        Dimension d = textFieldContainer.getPreferredSize();
        textFieldScrollPane.getViewport().setPreferredSize(
                new Dimension(d.width, 200));
        ui.add(textFieldScrollPane, BorderLayout.CENTER);
        JPanel textAreaContainer = new JPanel(new FlowLayout());
        textAreaContainer.setBorder(new EmptyBorder(10, 50, 10, 50));
        textAreaContainer.add(new JScrollPane(new JTextArea("Text area", 3, 20)));
        ui.add(textAreaContainer, BorderLayout.PAGE_START);

        JPanel buttonContainer = new JPanel(new BorderLayout());
        buttonContainer.setBorder(new EmptyBorder(10, 10, 10, 10));
        ui.add(buttonContainer, BorderLayout.PAGE_END);
        buttonContainer.add(new JButton("Line Start"), BorderLayout.LINE_START);
        buttonContainer.add(new JButton("Line End"), BorderLayout.LINE_END);
    }

    public JComponent getUI() {
        return ui;
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception useDefault) {
                }
                VerticalTextFields o = new VerticalTextFields();

                JFrame f = new JFrame(o.getClass().getSimpleName());
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.setLocationByPlatform(true);

                f.setContentPane(o.getUI());
                f.pack();
                f.setMinimumSize(f.getSize());

                f.setVisible(true);
            }
        };
        SwingUtilities.invokeLater(r);
    }
}