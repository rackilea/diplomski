public class CommandCreateSheet extends AbstractSheetCommand
{
    public CommandCreateSheet(Workbook workbook, String workSheetName)
    {
        super(workbook, workSheetName);
    }

    @Override
    public void execute() { this.workbook.addSheet(this.sheetName); }

    @Override
    public void undo() { this.workbook.removeSheet(this.sheetName);}
}

public class CommandDeleteSheet extends AbstractSheetCommand
{
    public CommandDeleteSheet(Workbook workbook, String workSheetName)
    {
        super(workbook, workSheetName);
    }

    @Override
    public void execute() { this.workbook.removeSheet(this.sheetName); }

    @Override
    public void undo() { this.workbook.addSheet(this.sheetName); }
}