Object actionKey = table.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT)
    .get(KeyStroke.getKeyStroke("TAB")); 
final Action traverseAction = table.getActionMap().get(actionKey);
Action wrapper = new AbstractAction() {
    @Override
    public void actionPerformed(ActionEvent e) {
        traverseAction.actionPerformed(e);
        while(shouldRepeat((JTable) e.getSource())) {
            traverseAction.actionPerformed(e);
        }
    }

    private boolean shouldRepeat(JTable source) {
        int leadRow = source.getSelectionModel().getLeadSelectionIndex();
        int leadColumn = source.getColumnModel().getSelectionModel().getLeadSelectionIndex();
        return !source.isCellEditable(leadRow, leadColumn);
    }
};
table.getActionMap().put(actionKey, wrapper);