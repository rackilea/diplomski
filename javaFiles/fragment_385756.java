/**
 * Main window class.
 */
public static void main(String args[]) {
    JFrame mainFrame = new JFrame();
    mainFrame.setLayout(new BorderLayout());
    mainFrame.setSize(100, 100);
    final StudentReader student = new StudentReader();

    JButton button = new JButton("Click Me");
    button.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Make the call here. Take note!
            // Look at the return type!
            List<String> strings = student.fileNames();
            for (String s : strings) {
                System.out.println(s);
            }
        }
    });
    mainFrame.add(button);
    mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    mainFrame.setVisible(true);
}

public class StudentReader {
    public List<String> fileNames() {
        // Do your magic here :)
        // Open a dialog. Get the files.
        // Return it as a list
        return Arrays.asList(new String[]{"Filename"});
    }
}