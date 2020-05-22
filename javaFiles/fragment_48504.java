JFileChooser chooser = new JFileChooser();
chooser.setCurrentDirectory(new java.io.File("."));
chooser.setDialogTitle("Hello");
chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
chooser.setAcceptAllFileFilterUsed(false);
if (chooser.showOpenDialog(f) == JFileChooser.APPROVE_OPTION) 
{ 
    File file = chooser.getSelectedFile();
    if (file.getName().contains("\""))
    {
        Pattern pattern = Pattern.compile("\"?(.*?)\"?");
        Matcher m = pattern.matcher(file.getName());
        if (m.matches())
        {
            System.out.println("Group Found: " + m.group(1));
        }
    }
}