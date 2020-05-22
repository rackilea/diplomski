public class ScrollTable extends Table {
    private Table mainTable;

    public void setDependentTable(Table mainTable) {
        this.mainTable = mainTable;
    }

    @Override
    public void paintContent(PaintTarget target) throws PaintException {

        target.addAttribute("scrollPane", this);
        if (mainTable != null) {
            target.addAttribute("dependentTable", mainTable);
        }
        super.paintContent(target);
    }
}