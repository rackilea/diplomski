public class Test {

    public static void main(final String[] args) {
        final Object[] options = { "OK", "Cancel" };
        JOptionPane.showOptionDialog(null, "Enter won't work.", "Title", 
                JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, 
                null, options, 
                null);  // this is the trick

        JOptionPane.showOptionDialog(null, "Can press Enter.", "Title", 
                JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, 
                null, options, options[1]);
    }
}