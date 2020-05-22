// The path to the documents directory.
string dataDir = RunExamples.GetDataDir(System.Reflection.MethodBase.GetCurrentMethod().DeclaringType);

// Open an existing excel file.
Workbook wb = new Workbook(dataDir+ "SampleInput.xlsx");

// Create a Worksheets object with reference to
// The sheets of the Workbook.
WorksheetCollection sheets = wb.Worksheets;

// Get first Worksheet from WorksheetCollection
Worksheet sheet = sheets[0];

// Delete the Blank Rows from the worksheet
sheet.Cells.DeleteBlankRows();

// Save the excel file.
wb.Save(dataDir+ "mybook.out.xlsx");