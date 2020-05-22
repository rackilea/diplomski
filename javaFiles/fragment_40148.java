import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

public class InterviewBrowser {

    public static void main(String[] args) {
        new InterviewBrowser();
    }

    public InterviewBrowser() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                DefaultMutableTreeNode root = new DefaultMutableTreeNode("Management");
                DefaultMutableTreeNode bigLeaf1 = new DefaultMutableTreeNode("Generl Affair");
                DefaultMutableTreeNode bigLeaf2 = new DefaultMutableTreeNode("Personal Affair");
                DefaultMutableTreeNode leaf2 = new DefaultMutableTreeNode(new InterviewHistory(
                                "Bob",
                                new Date(LocalDate.of(1972, Month.MARCH, 8).toEpochDay()),
                                Sex.MALE,
                                new Date(LocalDate.of(2015, Month.AUGUST, 10).toEpochDay()),
                                false,
                                "123456789"));
                DefaultMutableTreeNode leaf3 = new DefaultMutableTreeNode(new InterviewHistory(
                                "Jane",
                                new Date(LocalDate.of(1973, Month.JANUARY, 1).toEpochDay()),
                                Sex.FEMALE,
                                new Date(LocalDate.of(2015, Month.AUGUST, 10).toEpochDay()),
                                true,
                                "87654321"));

                bigLeaf1.add(leaf2);
                bigLeaf2.add(leaf3);
                root.add(bigLeaf1);
                root.add(bigLeaf2);
                DefaultTreeModel model = new DefaultTreeModel(root);

                JTree tree = new JTree(model);

                Viewer viewer = new Viewer();

                tree.addTreeSelectionListener(new TreeSelectionListener() {
                    @Override
                    public void valueChanged(TreeSelectionEvent e) {
                        TreePath path = e.getPath();
                        Object lastPathComponent = path.getLastPathComponent();
                        if (lastPathComponent instanceof DefaultMutableTreeNode) {
                            DefaultMutableTreeNode node = (DefaultMutableTreeNode) lastPathComponent;
                            Object userObject = node.getUserObject();
                            if (userObject instanceof InterviewHistory) {
                                InterviewHistory history = (InterviewHistory) userObject;
                                viewer.setHistory(history);
                            } else {
                                viewer.setHistory(null);
                            }
                        } else {
                            viewer.setHistory(null);
                        }
                    }
                });

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new JScrollPane(tree), BorderLayout.WEST);
                frame.add(viewer);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public enum Sex {

        MALE,
        FEMALE
    }

    public class InterviewHistory {

        private String name;
        private Date birthDate;
        private Sex sex;
        private Date interviewDate;
        private boolean passed;
        private String phone;

        public InterviewHistory(String name, Date birthDate, Sex sex, Date interviewDate, boolean passed, String phone) {
            this.name = name;
            this.birthDate = birthDate;
            this.sex = sex;
            this.interviewDate = interviewDate;
            this.passed = passed;
            this.phone = phone;
        }

        public String getName() {
            return name;
        }

        public Date getBirthDate() {
            return birthDate;
        }

        public Sex getSex() {
            return sex;
        }

        public Date getInterviewDate() {
            return interviewDate;
        }

        public boolean didPass() {
            return passed;
        }

        public String getPhone() {
            return phone;
        }

        @Override
        public String toString() {
            return getName();
        }

    }

    public static class Viewer extends JPanel {

        public static final DateFormat DATE_FORMAT = DateFormat.getDateInstance();

        private JTextField name;
        private JTextField dateOfBirth;
        private JLabel sex;
        private JTextField dateOfInterview;
        private JCheckBox passed;
        private JTextField phone;

        public Viewer() {
            setLayout(new GridBagLayout());

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.WEST;

            add(new JLabel("Name: "), gbc);
            gbc.gridy++;
            add(new JLabel("Date of birth: "), gbc);
            gbc.gridy++;
            add(new JLabel("Sex: "), gbc);
            gbc.gridy++;
            add(new JLabel("Date of Interview: "), gbc);
            gbc.gridy++;
            add(new JLabel("Passed interview: "), gbc);
            gbc.gridy++;
            add(new JLabel("Phone: "), gbc);

            name = new JTextField(25);
            dateOfBirth = new JTextField(10);
            sex = new JLabel("?");
            dateOfInterview = new JTextField(10);
            passed = new JCheckBox();
            phone = new JTextField(9);

            gbc.gridx++;
            gbc.gridy = 0;

            add(name, gbc);
            gbc.gridy++;
            add(dateOfBirth, gbc);
            gbc.gridy++;
            add(sex, gbc);
            gbc.gridy++;
            add(dateOfInterview, gbc);
            gbc.gridy++;
            add(passed, gbc);
            gbc.gridy++;
            add(phone, gbc);

        }

        public void setHistory(InterviewHistory history) {
            name.setText(history == null ? null : history.getName());
            dateOfBirth.setText(history == null ? null : DATE_FORMAT.format(history.getBirthDate()));
            sex.setText(history == null ? "?" : history.getSex().name());
            dateOfInterview.setText(history == null ? null : DATE_FORMAT.format(history.getInterviewDate()));
            passed.setSelected(history == null ? false : history.didPass());
            phone.setText(history == null ? "?" : history.getPhone());
        }

    }
}