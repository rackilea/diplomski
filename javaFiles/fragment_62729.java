public static final String extXlsx="xlsx";
public static final String extXls="xls";
// Put the above two strings above Public static void main()

if(extXlsx.equals(FilenameUtils.getExtension(excelPath))||
 extXls.equals(FilenameUtils.getExtension(excelPath))){
    FileInputStream fileInputStream = new FileInputStream(new File(excelPath));
        // Create Workbook instance holding .xls file
        //Excel Handling
    } else{
        System.out.println("\n******CSV FILE******\n");
        //CSV File handling
    }