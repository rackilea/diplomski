public class StudentProfile extends JFrame {

    public StudentProfile() {
    super("Student Profile");
    setSize(400, 400);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    Container c = getContentPane();

    c.setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();

    gbc.insets = new Insets(0, 0, 10, 0); //<---1 this to make a bottom gap after first label
    gbc.weightx = 1.0;
    //gbc.weighty = 1.0; <---2 take this from here
    gbc.gridheight = 1;
    gbc.gridwidth = 5;
    gbc.anchor = GridBagConstraints.FIRST_LINE_START;
    JLabel stProfile = new JLabel("Student Profile");
    c.add(stProfile, gbc);

    gbc.insets = new Insets(0, 0, 0, 0); //<---1 reset insets

    JPanel j1 = new JPanel();
    j1.setLayout(new GridBagLayout());
    GridBagConstraints gbc1 = new GridBagConstraints();
    gbc1.gridx = 0;
    gbc1.gridy = 0;
    JLabel stName = new JLabel("Student Name", SwingConstants.LEFT);
    j1.add(stName, gbc1);

    gbc1.gridy = 1;
    JLabel fName = new JLabel("Father Name", SwingConstants.LEFT);
    j1.add(fName, gbc1);
    gbc.weighty = 1.0; //<---2 here
    gbc.gridy = 1;

    c.add(j1, gbc);
}

public static void main (String[] agrs) {
    StudentProfile sp = new StudentProfile();
    sp.setVisible(true);
}