public class HashMapObjectTest {

    static HSSFSheet sheet;
    static HSSFRow row;
    private static MissingCellPolicy xRow;  
    static DataFormatter df = new DataFormatter();

    @Test
    public void  getMapData() throws Exception
    {
        File src=new File("D:\\Projects\\TestData_peerTest.xls");
        FileInputStream fis=new FileInputStream(src);
        HSSFWorkbook wb=new HSSFWorkbook(fis);
        sheet = wb.getSheetAt(0);

        Map<String,Map<String,String>>  superMap = new HashMap <String,Map<String,String>> ();

        //Start Index -> Question Type Start Index

        int startIndex=1;
        int endIndex=-1;
        int lastRow=sheet.getLastRowNum();

        while(startIndex<=lastRow){

            for(int i=startIndex;i<lastRow;i++){

                Row row=sheet.getRow(i+1);
                Cell c=row.getCell(0, MissingCellPolicy.RETURN_BLANK_AS_NULL);

                    if(c!=null){
                        endIndex=i;
                        break;
                    }
                    else if(i==lastRow-1){
                        endIndex=i+1;
                        break;
                    }

            }

            String keyQuestion=sheet.getRow(startIndex).getCell(0).getStringCellValue();
            Map<String,String> childMap=new HashMap<String,String>();

            for(int j=startIndex;j<=endIndex;j++){
                String label=sheet.getRow(j).getCell(1).getStringCellValue();
                String value=sheet.getRow(j).getCell(2).getStringCellValue();
                childMap.put(label, value);
            }

            System.out.println(childMap);
            superMap.put(keyQuestion,childMap);
            startIndex=endIndex+1;

        }

        System.out.println(superMap);

    }