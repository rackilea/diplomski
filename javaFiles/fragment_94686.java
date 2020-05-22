String table = [{}{}{}];
JSONArray arrayJson = new JSONArray(table);

FileOutputStream fos = null ;

FileInputStream fis = new FileInputStream(new File("D:/File/filename1.xlsx"));
XSSFWorkbook workbook = new XSSFWorkbook (fis);
XSSFSheet sheet = workbook.getSheetAt(0);
//Create rows
XSSFRow row0 = sheet.createRow(0);
XSSFCell r1c0 = row0.createCell(0);
r1c0.setCellValue("Name");

XSSFRow row1 = sheet.createRow(1);
XSSFCell r1c1 = row1.createCell(0);
r1c1.setCellValue("Location");

XSSFRow row2 = sheet.createRow(2);
XSSFCell r1c2 = row2.createCell(0);
r1c2.setCellValue("Distance");

XSSFRow row3 = sheet.createRow(3);
XSSFCell r1c3 = row3.createCell(0);
r1c3.setCellValue("Super built up area (in sq.ft)");

XSSFRow row4 = sheet.createRow(4);
XSSFCell r1c4 = row4.createCell(0);
r1c4.setCellValue("No of basement/s & floors");

XSSFRow row5 = sheet.createRow(5);
XSSFCell r1c5 = row5.createCell(0);
r1c5.setCellValue("Average floor plate");

XSSFRow row6 = sheet.createRow(6);
XSSFCell r1c6 = row6.createCell(0);
r1c6.setCellValue("Distance");

XSSFRow row7 = sheet.createRow(7);
XSSFCell r1c7 = row7.createCell(0);
r1c7.setCellValue("Super Built area");

XSSFRow row8 = sheet.createRow(8);
XSSFCell r1c8 = row8.createCell(0);
r1c8.setCellValue("Name");

XSSFRow row9 = sheet.createRow(9);
XSSFCell r1c9 = row9.createCell(0);
r1c9.setCellValue("Location");

XSSFRow row10 = sheet.createRow(10);
XSSFCell r1c10 = row10.createCell(0);
r1c10.setCellValue("Distance");

XSSFRow row11 = sheet.createRow(11);
XSSFCell r1c11 = row11.createCell(0);
r1c11.setCellValue("Super built up area (in sq.ft)");

XSSFRow row12 = sheet.createRow(12);
XSSFCell r1c12 = row12.createCell(0);
r1c12.setCellValue("No of basement/s & floors");

XSSFRow row13 = sheet.createRow(13);
XSSFCell r1c13 = row13.createCell(0);
r1c13.setCellValue("Average floor plate");

XSSFRow row14 = sheet.createRow(14);
XSSFCell r1c14 = row14.createCell(0);
r1c14.setCellValue("Distance");

XSSFRow row15 = sheet.createRow(15);
XSSFCell r1c15 = row15.createCell(0);
r1c15.setCellValue("Super Built area");

XSSFRow row16 = sheet.createRow(16);
XSSFCell r1c16 = row16.createCell(0);
r1c16.setCellValue("Name");

XSSFRow row17 = sheet.createRow(17);
XSSFCell r1c17 = row17.createCell(0);
r1c17.setCellValue("Location");

XSSFRow row18 = sheet.createRow(18);
XSSFCell r1c18 = row18.createCell(0);
r1c18.setCellValue("Distance");

XSSFRow row19 = sheet.createRow(19);
XSSFCell r1c19 = row19.createCell(0);
r1c19.setCellValue("Super built up area (in sq.ft)");

XSSFRow row20 = sheet.createRow(20);
XSSFCell r1c20 = row20.createCell(0);
r1c20.setCellValue("No of basement/s & floors");

XSSFRow row21 = sheet.createRow(21);
XSSFCell r1c21 = row21.createCell(0);
r1c21.setCellValue("Average floor plate");

XSSFRow row22 = sheet.createRow(22);
XSSFCell r1c22 = row22.createCell(0);
r1c22.setCellValue("Distance");

String projectname = null;
for(int i =0 ;i<arrayJson.length();i++) {
    projectname = arrayJson.get(i).toString();
    System.out.println("name : "+projectname);  

    JSONObject obj = new JSONObject(projectname);

    XSSFRow row00 = sheet.getRow(0);
    XSSFCell r1c00 = row00.createCell(i+1);
    r1c00.setCellValue( obj.getString("name"));
    XSSFRow row102 = sheet.getRow(1);
    XSSFCell r1c102 = row102.createCell(i+1);
    r1c102.setCellValue(obj.getString("location"));
    XSSFRow row202 = sheet.getRow(2);
    XSSFCell r1c202 = row202.createCell(i+1);
    r1c202.setCellValue(obj.getString("distance"));
    XSSFRow row30 = sheet.getRow(3);
    XSSFCell r1c30 = row30.createCell(i+1);
    r1c30.setCellValue(obj.getString("superarea"));
    XSSFRow row40 = sheet.getRow(4);
    XSSFCell r1c40 = row40.createCell(i+1);
    r1c40.setCellValue(obj.getString("basement"));
    XSSFRow row50 = sheet.getRow(5);
    XSSFCell r1c50 = row50.createCell(i+1);
    r1c50.setCellValue(obj.getString("floorplate"));
    XSSFRow row60 = sheet.getRow(6);
    XSSFCell r1c60 = row60.createCell(i+1);
    r1c60.setCellValue(obj.getString("area_offered"));
    XSSFRow row70 = sheet.getRow(7);
    XSSFCell r1c70 = row70.createCell(i+1);
    r1c70.setCellValue(obj.getString("floors_offered"));
    XSSFRow row80 = sheet.getRow(8);
    XSSFCell r1c80 = row80.createCell(i+1);
    r1c80.setCellValue(obj.getString("component_rent"));
    XSSFRow row90 = sheet.getRow(9);
    XSSFCell r1c90 = row90.createCell(i+1);
    r1c90.setCellValue(obj.getString("power_available"));
    XSSFRow row100 = sheet.getRow(10);
    XSSFCell r1c100 = row100.createCell(i+1);
    r1c100.setCellValue(obj.getString("power_backup"));
    XSSFRow row110 = sheet.getRow(11);
    XSSFCell r1c110 = row110.createCell(i+1);
    r1c110.setCellValue(obj.getString("parking_slot"));
    XSSFRow row120 = sheet.getRow(12);
    XSSFCell r1c120 = row120.createCell(i+1);
    r1c120.setCellValue(obj.getString("occupation"));
    XSSFRow row130 = sheet.getRow(13);
    XSSFCell r1c130 = row130.createCell(i+1);
    r1c130.setCellValue(obj.getString("lease_tenure"));
    XSSFRow row140 = sheet.getRow(14);
    XSSFCell r1c140 = row140.createCell(i+1);
    r1c140.setCellValue(obj.getString("lock_period"));
    XSSFRow row150 = sheet.getRow(15);
    XSSFCell r1c150 = row150.createCell(i+1);
    r1c150.setCellValue(obj.getString("notice_period"));
    XSSFRow row160 = sheet.getRow(16);
    XSSFCell r1c160 = row160.createCell(i+1);
    r1c160.setCellValue(obj.getString("quoted_rent"));
    XSSFRow row170 = sheet.getRow(17);
    XSSFCell r1c170 = row170.createCell(i+1);
    r1c170.setCellValue(obj.getString("area_main"));
    XSSFRow row180 = sheet.getRow(18);
    XSSFCell r1c180 = row180.createCell(i+1);
    r1c180.setCellValue(obj.getString("carpark_slot"));
    XSSFRow row190 = sheet.getRow(19);
    XSSFCell r1c190 = row190.createCell(i+1);
    r1c190.setCellValue(obj.getString("rent_review"));
    XSSFRow row200 = sheet.getRow(20);
    XSSFCell r1c200 = row200.createCell(i+1);
    r1c200.setCellValue(obj.getString("security_deposit"));
    XSSFRow row210 = sheet.getRow(21);
    XSSFCell r1c210 = row210.createCell(i+1);
    r1c210.setCellValue(obj.getString("taxes"));
    /*XSSFRow row220 = sheet.getRow(22);
    XSSFCell r1c220 = row220.createCell(i+1);
    r1c220.setCellValue(obj.getString("contact_no"));*/
}

fis.close();
fos =new FileOutputStream(new File("D:/File/filename1.xlsx"));
workbook.write(fos);
fos.flush();
fos.close();