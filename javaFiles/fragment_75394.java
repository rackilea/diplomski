JOptionPane optionPane = new JOptionPane(
    "Are you sure you want to exit the application",
    JOptionPane.QUESTION_MESSAGE,
    JOptionPane.YES_NO_CANCEL_OPTION);

List<JButton> buttons = SwingUtils.getDescendantsOfType(JButton.class, optionPane, true);

for (JButton button: buttons)
{
    System.out.println( button.getText() );
}