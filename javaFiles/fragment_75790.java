private final class FocusChangeHandler implements PropertyChangeListener {
    @Override
    public void propertyChange(final PropertyChangeEvent evt) {
        final String propertyName = evt.getPropertyName();
        if (!"permanentFocusOwner".equals(propertyName)) {
            return;
        }

        final Component focusOwner = KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner();

        final String focusHint = (focusOwner instanceof JComponent) ? ((String) ValidationComponentUtils.getInputHint((JComponent) focusOwner))
                : null;
        final int scrollBarPosition = panelScrollPane.getVerticalScrollBar().getValue();
        infoAreaPane.setVisible(focusHint != null);
        infoArea.setText(infoHint);
        if(focusHint != null) {
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                   public void run() { 
                       panelScrollPane.getVerticalScrollBar().setValue(scrollBarPosition);
                   }
                });
        }
    }
}