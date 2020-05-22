class Menu {
    public String showMenu(){
        //i solved my problem adding the following 2 lines of code...
        JFrame frame = new JFrame();
        frame.setAlwaysOnTop(true);

        Object[] options = {"option1", "option2", "option3"};
        //...and passing `frame` instead of `null` as first parameter
        Object selectionObject = JOptionPane.showInputDialog(frame, "Choose", "Menu", JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        String selectionString = selectionObject.toString();
        return selectionString;
    }
}