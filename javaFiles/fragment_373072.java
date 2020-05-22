public class StudentDialog extends JDialog {

    private JTextField field;

    public StudentDialog(Frame owner) {
        super(owner);
        setModal(true);
        field = new JTextField();
        // I assume you're actually adding this text field to the dialog
    }

    public Student getStudent {
        return new Student(field.getText());
    }

}