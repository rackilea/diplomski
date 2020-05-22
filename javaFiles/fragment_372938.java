String file = form.getFile().getOriginalFilename();
String[] dateParts = file.split("-");
String year = dateParts[0]; 
String month = dateParts[1]; 
String day = dateParts[2]; 
String UPLOADED_FOLDER = "C://Users//pandeyv//Desktop//"+year+"//"+month+"//"+day+"//";
File dir = new File(UPLOADED_FOLDER);
if (!dir.exists())
    dir.mkdirs();