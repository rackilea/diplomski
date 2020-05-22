public class Listener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {// right click key
        JOptionPane.showMessageDialog(dialogFrame, "Developer: Joe"
                , "Developer",
                JOptionPane.INFORMATION_MESSAGE);
    }// end actionPerformed method
});