public abstract class AbstactSheetCommand implements Command
{
    private Workbook workbook;
    private String sheetName;

    protected AbstractSheetCommand(Workbook workbook, String workSheetName)
    {
        this.workbook = workbook;
        this.sheetName = workSheetName;
    }

    public abstract void execute();
    public abstract void undo();
}