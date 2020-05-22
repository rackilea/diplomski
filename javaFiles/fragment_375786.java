String dataDir = "D:\\data\\";
// Create or load workbook
Workbook book = new Workbook();

// Get the first worksheet
Worksheet sheet = book.getWorksheets().get(0);

Style style;
StyleFlag flag = new StyleFlag();

// First lock all columns
for (int iCol=0 ; iCol<255 ; iCol++)
{
    // Get style of the column
    style = sheet.getCells().getColumns().get(iCol).getStyle();
    // Apply locking to the style
    style.setLocked(true);
    flag.setLocked(true);
    sheet.getCells().getColumns().get(iCol).applyStyle(style, flag);
}

// Get the range of cells, which we want to unlock
Range rangeUnlocked = sheet.getCells().createRange("A1:D4");
// Add a new style
int styleIndex = book.getStyles().add();
Style styleUnlocked = book.getStyles().get(styleIndex);
// Unlock cells
styleUnlocked.setLocked(false);
rangeUnlocked.setStyle(styleUnlocked);

// Protect the sheet
sheet.protect(ProtectionType.ALL);

//Save the Excel file
book.save(dataDir + "protectedrange.xlsx");