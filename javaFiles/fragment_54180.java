//b2.grabFocus();
b2.requestFocusInWindow();


SwingUtilities.invokeLater(new Runnable()
{
    public void run()
    {

        // First - Always returns false
        if(frame.getFocusOwner() instanceof JButton) {
        JButton focusedButton = (JButton) frame.getFocusOwner();
        focusedButton.doClick();
        System.out.println("In focus?");
        }
        else {
            System.out.println("Apparently not");
        }

        // Second - Also always returns false
        if(b2.isFocusOwner()) {
            System.out.println("In focus...");
        }
        else {
            System.out.println("Not in focus");
       }
    }
});