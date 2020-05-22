import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class Test extends JFrame {
    final JPanel panel;
    final JTextArea textArea;
    final FormLayout fl;
    public Test() {
        this.setBounds(100, 100, 450, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fl = new FormLayout(
                new ColumnSpec[] {ColumnSpec.decode("pref:grow"), 
//                      ColumnSpec.decode("pref:grow")
                        },
                new RowSpec[] {RowSpec.decode("pref:grow"), 
//                      RowSpec.decode("pref:grow")
                        }
            );
        panel = new JPanel(fl);
        this.getContentPane().add(panel, BorderLayout.CENTER);
        textArea = new JTextArea();
        textArea.setPreferredSize(new Dimension());

        panel.add(new JPanel().add(textArea), "1, 1, fill, fill");
//        panel.add(new JPanel().add(new JLabel("test")), "1, 2, fill, fill");
//        panel.add(new JPanel().add(new JLabel("test")), "2, 1, fill, fill");
        textArea.setLineWrap(true);
//        textArea.setWrapStyleWord(true);
        textArea.setText("Lorem ipsum dolor sit amet, ut eum assum "
                + "debet tacimates, mei nisl electram moderatius ei, veri semper cotidieque eu pri. In quot noster vocent usu, "
                + "ne augue voluptaria quo. Ex per malis vocibus. Consequat mediocritatem no vel.");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Test().setVisible(true);
            }
        });
    }
}