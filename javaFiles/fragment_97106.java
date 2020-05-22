// ActionListener (and more) for the button
    private class ButtonPressAction extends AbstractAction {
        public ButtonPressAction(String name, int mnemonic) {
            super(name);  // text to show in button
            putValue(MNEMONIC_KEY, mnemonic);  // alt-key mnemonic key for button
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            setCounter(counter + 1);  // re-sets the counter and displays it
            timer.restart();   // re-sets and runs the timer
        }
    }