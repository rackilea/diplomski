@SuppressWarnings("serial")
class FillTableAction extends AbstractAction {
    private TablePanel tablePanel;

    public FillTableAction(TablePanel tablePanel) {
        super("Fill Table");
        putValue(MNEMONIC_KEY, KeyEvent.VK_F);
        this.tablePanel = tablePanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        tablePanel.fillTable();
    }
}