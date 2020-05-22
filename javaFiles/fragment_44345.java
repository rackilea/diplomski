public class Object {

    private static final String FIRST_ACTION = "firstAction";
    private static final String SECOND_ACTION = "firstAction";


    public Object() {

        JButton button1 = new JButton("1");
        button1.setActionCommand(FIRST_ACTION);

        JButton button2 = new JButton("2");
        button2.setActionCommand(SECOND_ACTION);

        JButton button3 = new JButton("3");

        // creating action listener and adding it to buttons and adding buttons
        // to frame

    }

    public class listen implements ActionListener {

        //some code

        public void actionPerformed(ActionEvent aE) {
            if (aE.getActionCommand().equals(FIRST_ACTION)) {
                // change someInt
            } else if (aE.getActionCommand().equals(SECOND_ACTION)) {

            }
            // same thing for other buttons
        }
    }
}