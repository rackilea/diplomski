String localPDF = "empty28.pdf";
String originDir = "\\\\smb\\ProdName\\ShareName\\Temp\\username\\path\\to\\file\\";

File file = new File(originDir + localPDF);   
SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

System.out.println(sdf.format(file.lastModified()));