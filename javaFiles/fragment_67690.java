import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.jdesktop.swingx.JXDatePicker;

public class TestDatePicker {

    public static void main(String[] args) {
        new TestDatePicker();
    }

    public TestDatePicker() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private JXDatePicker issueDate;
        private final JXDatePicker returnDate;

        public TestPane() {
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;

            JLabel lblIssueDate = new JLabel("Issue Date");
            add(lblIssueDate, gbc);

            issueDate = new JXDatePicker();
            returnDate = new JXDatePicker();

            issueDate.addPropertyChangeListener("date", new PropertyChangeListener() {
                @Override
                public void propertyChange(PropertyChangeEvent evt) {
                    System.out.println("date");
                    Date selectedDate = issueDate.getDate();
                    returnDate.getMonthView().setLowerBound(selectedDate);
                }
            });
            java.util.Date utilDate = new Date();
            java.sql.Date sqldate = new java.sql.Date(utilDate.getTime());
            issueDate.setDate(sqldate);
            gbc.gridx++;
            add(issueDate, gbc);

            gbc.gridx = 0;
            gbc.gridy++;
            JLabel lblReturnDate = new JLabel("Return Date");
            add(lblReturnDate, gbc);

            gbc.gridx++;
            add(returnDate, gbc);
        }
    }

}