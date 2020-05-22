public class StudentProfile extends JFrame {

    private Container container;
    private JPanel studentProfileInfoPanel;

    public StudentProfile(String title) {
        super(title);
    }

    public void createStudentProfile() {
        this.setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.container = this.getContentPane();

        this.container.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(0, 0, 10, 0);
        gbc.weightx = 1.0;
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.NORTHWEST;

        JLabel studentProfileLabel = new JLabel("Student Profile");
        this.container.add(studentProfileLabel, gbc);

        this.createStudentProfileInfoPanel();

        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.weighty = 1.0;
        gbc.gridy++;
        //gbc.fill=GridBagConstraints.NONE; //<--- try using this, see what happens
        this.container.add(studentProfileInfoPanel, gbc);
    }

    private void createStudentProfileInfoPanel() {
        this.studentProfileInfoPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10,0,0,10);
        gbc.weightx = 1;

        gbc.gridx = 0;
        gbc.gridy = 0;
        JLabel studentNameLabel = new JLabel("Student Name");
        this.studentProfileInfoPanel.add(studentNameLabel, gbc);

        gbc.gridx++;
        this.studentProfileInfoPanel.add(new JLabel ("Adam Smith Jr"), gbc);

        gbc.gridx=0;
        gbc.gridy++;
        JLabel studentFatherNameLabel = new JLabel("Father Name");
        this.studentProfileInfoPanel.add(studentFatherNameLabel, gbc);

        gbc.weighty = 1;
        gbc.gridx++;
        this.studentProfileInfoPanel.add(new JLabel("Adam Smith"), gbc);
    }

    public static void main(String[] agrs) {
        StudentProfile studentProfile = new StudentProfile("Student Profile");
        studentProfile.createStudentProfile();

        SwingUtilities.invokeLater(() -> {
            studentProfile.setVisible(true);
        });
    }
}