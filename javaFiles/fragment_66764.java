String startPath = "C://Users//me//Documents//Test";
JFileChooser openFile = new JFileChooser(new File(startPath));
openFile.showOpenDialog(null);

File fileChoosen = openFile.getSelectedFile();
String fileName = openFile.getSelectedFile().getName();
String filePathAndName = openFile.getSelectedFile().getPath();

//Do what you want with the variables...
System.out.println(fileName);
System.out.println(filePathAndName);