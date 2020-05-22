import java.io.*;

    import org.apache.poi.hssf.usermodel.HSSFWorkbook;
    import org.apache.poi.hssf.usermodel.HSSFSheet;
    import org.apache.poi.ss.usermodel.*;
    import org.apache.poi.xssf.usermodel.XSSFSheet;
    import org.apache.poi.xssf.usermodel.XSSFWorkbook;

    import java.util.*;
    import java.sql.*; 

    public class XLToDB {  

        public static final String INSERT_RECORDS = "INSERT INTO RECORDS(ID, NAME, VALUE1, VALUE2, VALUE3, VALUE4, VALUE5) VALUES(?,?,?,?,?,?,?)";
        private static String GET_COUNT = "SELECT COUNT(*) FROM RECORDS";

        public static void main(String[] args) throws Exception{
            XLToDB obj = new XLToDB();
            obj.insertRecords("E:/test.xlsx");



        }
              public void insertRecords(String filePath){

                /* Create Connection objects */
            Connection con = null;
            PreparedStatement prepStmt = null;
            java.sql.Statement stmt = null;
            int count = 0;
            ArrayList<String> mylist = new ArrayList<String>();

            try{
                con = DBHelper.getConnection();
                System.out.println("Connection :: ["+con+"]");
                prepStmt = con.prepareStatement(INSERT_RECORDS);
                stmt = con.createStatement();
                ResultSet result = stmt.executeQuery(GET_COUNT);
                while(result.next()) {

                    int val = result.getInt(1);
                    System.out.println(val);
                    count = val+1;

                }


                //prepStmt.setInt(1,count);

                /* We should now load excel objects and loop through the worksheet data */
                FileInputStream fis = new FileInputStream(new File(filePath));
                System.out.println("FileInputStream Object created..! ");
                 /* Load workbook */
                XSSFWorkbook workbook = new XSSFWorkbook (fis);
                System.out.println("XSSFWorkbook Object created..! ");
                /* Load worksheet */
                XSSFSheet sheet = workbook.getSheetAt(0);
                System.out.println("XSSFSheet Object created..! ");
                   // we loop through and insert data
                Iterator ite = sheet.rowIterator();
                System.out.println("Row Iterator invoked..! ");

                   while(ite.hasNext()) {
                            Row row = (Row) ite.next(); 
                            System.out.println("Row value fetched..! ");
                            Iterator<Cell> cellIterator = row.cellIterator();
                            System.out.println("Cell Iterator invoked..! ");
                            int index=1;
                                    while(cellIterator.hasNext()) {

                                            Cell cell = cellIterator.next();
                                            System.out.println("getting cell value..! ");

                                            switch(cell.getCellType()) { 
                                            case Cell.CELL_TYPE_STRING: //handle string columns
                                                    prepStmt.setString(index, cell.getStringCellValue());                                                                                     
                                                    break;
                                            case Cell.CELL_TYPE_NUMERIC: //handle double data
                                                int i = (int)cell.getNumericCellValue();
                                                prepStmt.setInt(index, (int) cell.getNumericCellValue());
                                                    break;
                                            }
                                            index++;



                                    }
                    //we can execute the statement before reading the next row
                    prepStmt.executeUpdate();
                    }
                   /* Close input stream */
                   fis.close();
                   /* Close prepared statement */
                   prepStmt.close();

                   /* Close connection */
                   con.close();

            }catch(Exception e){
                e.printStackTrace();            
            }

            }
    }


my excel is like below

101 Mobiles 10  10  10  10  10
102 Batteries   20  21  22  20  56
103 Watches 25  242 52  55  28
104 Keyboards   10  11  12  12  12
105 Pens    5   5   5   5   3
----------------------------------->
in my database it saves  in this direction[--------------------->>>]