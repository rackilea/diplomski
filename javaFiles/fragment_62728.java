public class TP
{
public static final String extXlsx="xlsx";
public static void main(String[] args) throws FileNotFoundException
{
    try
    {

        String ext1 = FilenameUtils.getExtension("C:\\Users\\swapnil.sanjay.saraf\\Desktop\\Input.xlsx"); // returns "txt"
        String ext2 = FilenameUtils.getExtension("C:\\Users\\swapnil.sanjay.saraf\\Desktop\\Input2.csv"); // returns "exe"
        String input = null;
        String excelPath = "C:\\Users\\swapnil.sanjay.saraf\\Desktop\\Input.xlsx";
        System.out.println(FilenameUtils.getExtension(excelPath));
        if(ext1.equals(FilenameUtils.getExtension(excelPath))){

            FileInputStream fileInputStream = new FileInputStream(new File(excelPath));

            // Create Workbook instance holding .xls file
            //Excel Handling
        } else{
            System.out.println("\n******CSV FILE******\n");
            //CSV File handling
        }
    }
    catch (IOException ie){
        ie.printStackTrace();
    }
  }
}