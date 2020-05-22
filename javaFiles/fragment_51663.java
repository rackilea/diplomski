int i=0;
while((str=br.readLine())!=null){
row = sheet.createRow((short) i);
cell = row.createCell(i);
cell.setCellValue("UserName");//Set UserName after getting it from 'str'
i++;
}