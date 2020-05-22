// New class file named testPanel.java
public class testPanel extends JPanel{
    // Constructor
    public textPanel(){
        // Add an example button
        JButton btn_exit = new JButton("Exit");
        btn_exit.addActionListener(new ExitButtonListener());
        buttons.add(btn_exit);
    }

    // Private inner class which does event handling for our example button
    private class ExitButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            System.exit(0);
        }
    }

   // Add whatever other code you like here or above or anywhere else :)
}