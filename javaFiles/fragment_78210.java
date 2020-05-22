public class CommandRenameSheet extends AbstractSheetCommand
{
    private String newWorkSheetName;

    public CommandDeleteSheet(Workbook workbook, String oldWorkSheetName, String newWorkSheetName)
    {
        super(workbook, oldWorkSheetName);
        this.newWorkSheetName = newWorkSheetName;
    }

    @Override
    public void execute() 
    { this.workbook.renameSheet(this.sheetName, newWorkSheetName); }

    @Override
    public void undo() 
    { this.workbook.renameSheet(newWorkSheet, this.sheetName); }
}