private JDialog dialog;

private String inputValue;

String showPromptDialog(Frame parent) {
    dialog = new JDialog(parent, true);
    dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

    // [add components to dialog here]

    firstButton.setAction(new ButtonAction("Button 1",  "first"));
    secondButton.setAction(new ButtonAction("Button 2", "second"));
    thirdButton.setAction(new ButtonAction("Button 3",  "third"));
    fourthButton.setAction(new ButtonAction("Button 4", "fourth"));
    fifthButton.setAction(new ButtonAction("Button 5",  "fifth"));
    sixthButton.setAction(new ButtonAction("Button 6",  "sixth"));

    dialog.pack();
    dialog.setLocationRelativeTo(parent);

    inputValue = null;
    dialog.setVisible(true);

    return inputValue;
}

private class ButtonAction
extends AbstractAction {
    private static final long serialVersionUID = 1;

    ButtonAction(String text,
                 String actionCommand) {
        super(text);
        putValue(ACTION_COMMAND_KEY, actionCommand);
    }

    public void actionPerformed(ActionEvent event) {
        inputValue = event.getActionCommand();
        dialog.dispose();
    }
}