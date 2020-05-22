File dir = new File("G:\\Project\\Attachments");
FileSystemView fsv = new SingleRootFileSystemView(dir);
JFileChooser fileChooser = new JFileChooser(fsv);
int returnVal = fc.showOpenDialog(fileChooser);

if (returnVal == JFileChooser.APPROVE_OPTION) {