@SuppressWarnings("serial")
class ClearTableAction extends AbstractAction {
    private TablePanel tablePanel;

    public ClearTableAction(TablePanel tablePanel) {
        super("Clear Table");
        putValue(MNEMONIC_KEY, KeyEvent.VK_C);
        this.tablePanel = tablePanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        tablePanel.clearTable();
    }
}