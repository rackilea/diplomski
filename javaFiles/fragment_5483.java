public SelectionDialog(final JFrame frame, boolean modal, String attachmentName, Long processInstance, String processName) {
    super(frame, modal);
    try {
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
        e.printStackTrace();
    }

    response = JOptionPane.showConfirmDialog(frame, "Would you like to apply the policy attachment " + attachmentName + " to current instance (" + processInstance + ") of process " + processName + " ?", "Confirm",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
}