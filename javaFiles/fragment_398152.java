import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class Test extends JFrame {

    JButton jbtOk, jbtExit;

    JPanel p = new JPanel(new GridLayout(0, 1));
    JPanel gui = new JPanel(new BorderLayout(2, 2));

    public Test() {

        super("t");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel test = test();
        JPanel testing = testing();
        JPanel testing123 = testing123();
        p.add(test);
        p.add(testing);
        add(p, BorderLayout.CENTER);
        add(testing123, BorderLayout.PAGE_END);
        pack();
        setVisible(true);
    }

    private JPanel test() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel labelFields = new JPanel(new BorderLayout(2, 2));
        labelFields.setBorder(new TitledBorder("m"));
        p.add(gui);
        p.add(labelFields);
        JPanel labels = new JPanel(new GridLayout(0, 1, 1, 1));
        labels.setBorder(new TitledBorder("a"));
        JPanel fields = new JPanel(new GridLayout(0, 1, 1, 1));
        fields.setBorder(new TitledBorder("b"));

        p.add(labels);
        p.add(fields);
        return gui;
    }

    private JPanel testing() {
        JPanel guiCenter = new JPanel(new FlowLayout(FlowLayout.CENTER));
        guiCenter.setBorder(new TitledBorder("n"));
        guiCenter.add(new JScrollPane(new JTextArea(5, 30)));
        gui.add(guiCenter, BorderLayout.CENTER);
        return guiCenter;
    }

    private JPanel testing123() {
        JPanel j = new JPanel(new FlowLayout());
        jbtOk = new JButton("OK");
        jbtOk.setMnemonic('K');
        jbtExit = new JButton("Exit");
        jbtExit.setMnemonic('x');

        j.add(jbtOk);
        j.add(jbtExit);

        return j;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Test();
            }
        });
    }
}