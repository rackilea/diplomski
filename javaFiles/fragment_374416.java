import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class ResizeJTextArea {

    private JFrame frame = new JFrame();
    private JScrollPane scrollPane = new JScrollPane();
    private JTextArea textArea = new JTextArea(10, 15);
    private JButton button = new JButton("change");
    private Font newFont = new Font("Courier", Font.PLAIN, 10);

    public ResizeJTextArea() {
        textArea.setText("This is just a line of text");
        textArea.setFont(newFont);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setFont(textArea.getFont().deriveFont(20f));

                //2. choice
                //textArea.setColumns(20);
                //textArea.setRows(20);

                //3rd. coice
                //override PreferredScrollableViewportSize
                frame.pack();
            }
        });
        scrollPane.setViewportView(textArea);
        frame.add(scrollPane);
        frame.add(button, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(100, 100);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ResizeJTextArea fs = new ResizeJTextArea();
            }
        });
    }
}