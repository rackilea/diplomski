import javax.swing.*;

class Options {

    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater( new Runnable() {
            public void run() {
                Object[] options = {
                    "Option 1",
                    "Option 2",
                    "Option 3",
                    "Option 4",
                    "Option 5",
                    "Option 6",
                    "Option 7",
                    "None of the above" 
                };
                JComboBox optionList = new JComboBox(options);
                optionList.setSelectedIndex(7);
                JOptionPane.showMessageDialog(null, optionList, "Title",
                     JOptionPane.QUESTION_MESSAGE);
            }
        });
    }
}