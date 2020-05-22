public class SpinnerTester {

    public static void main(String[] args) {

        JSpinner spinner = new JSpinner(new SpinnerNumberModel(1, 0, 100, 1));


        //disable invalid input from being typed into spinner
        JFormattedTextField textField = ((JSpinner.NumberEditor) spinner.getEditor()).getTextField();
        ((NumberFormatter) textField.getFormatter()).setAllowsInvalid(false);

        /**
         * Change look and field
         */
        try {
            UIManager.setLookAndFeel(new MyLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(spinner);
        frame.setVisible(true);
        frame.pack();

    }

    /**
     * Create Look and Feel without beeps
     */
    public static class MyLookAndFeel extends NimbusLookAndFeel {
        @Override
        public void provideErrorFeedback(Component component) {
            //super.provideErrorFeedback(component);
        }
    }
}