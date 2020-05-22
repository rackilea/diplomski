Statement stmt = conn.createStatement();
      String filename="C:/Users/sangu/Downloads/data.xls" ;
     HSSFWorkbook hwb=new HSSFWorkbook();
     HSSFSheet sheet =  hwb.createSheet("sheet");


         ResultSet res = stmt.executeQuery("select * from login ");
         while (res.next())
        {        
             HSSFRow row=   sheet.createRow((short)0);
             String cg = res.getString(1);
             String cd = res.getString(3);
             row.createCell((short) 0).setCellValue(cd);
     row.createCell((short) 1).setCellValue(cd);
     row.createCell((short) 1).setCellValue(cd);                
             %>
             <tr>
             <td align="center"><%=cg%></td>
             <td align="center"><%=cd%></td>
             </tr>
            <%
     FileOutputStream fileOut =  new FileOutputStream(filename);
     hwb.write(fileOut);
     fileOut.close();
     out.println("Your excel file has been generated!");
                    hwb.write(response.getOutputStream()); }