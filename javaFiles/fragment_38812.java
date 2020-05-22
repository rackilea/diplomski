public class csvxls{
     public static void main(String[]args){
    try{

    File folder = new File("F:/csvfiles/");
    File[] listOfFiles = folder.listFiles();
    HSSFWorkbook workbook=new HSSFWorkbook();

    for (File file : listOfFiles) {


        if (file.isFile()) {

            String thisline;
            ArrayList<String> al = null;
            ArrayList<ArrayList<String>> arlist = new ArrayList<ArrayList<String>>();

            HSSFSheet sheet =  workbook.createSheet(file.getName());  
                FileInputStream fis = new FileInputStream(file);
                BufferedReader br = new BufferedReader(new InputStreamReader(fis));

                while ((thisline = br.readLine()) != null) {
                    al = new ArrayList<String>();
                    String strar[] = thisline.split(",");

                    for (int j = 0; j < strar.length; j++) { 
                        for (int k = 0; k < arlist.size(); k++) {

                            ArrayList<String> ardata = (ArrayList<String>) arlist.get(k);

                            HSSFRow row = sheet.createRow((short) k);


                            for (int p = 0; p < ardata.size(); p++) {

                                HSSFCell cell = row.createCell((short) p);
                                cell.setCellValue(ardata.get(p).toString());

                            }
                        }

                        al.add(strar[j]);

                    } 

                  arlist.add(al);
                }

                fis.close();  
                FileOutputStream fileOut = new FileOutputStream("F://NewWBFile.xls");
                workbook.write(fileOut);
                fileOut.flush();
                fileOut.close();
                br.close();
        }
        }

    System.out.println("Your excel file has been generated!");

    } catch ( Exception ex ) {
        System.out.println(ex);

    }
       }
   }