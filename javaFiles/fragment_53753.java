ArrayList<ExcelSheet> sheets = new ArrayList<ExcelSheet>();
for(int i = 0; i < wb.getNumberOfSheets(); i++)
{
    if(ParserTools.isLegitSheet(wb.getSheetAt(i)))
    {
            sheets.add(new ExcelSheet(null)); //ERROR HERE
    }
}
this.sheets = sheets;