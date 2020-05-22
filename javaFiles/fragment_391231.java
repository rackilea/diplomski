// get the full path of the file
String absolutePath = saveFile.getSelectedFile().getAbsolutePath();  

// does the selected file have an extension of docx?
// if yes then exclude the extension, if no, then add .docx to the file name
if (!absolutePath.substring(absolutePath.lastIndexOf(".")+1).equals("docx"))     
     absolutePath += ".docx";                                                     

FileWriter fileWriter = new FileWriter(absolutePath);