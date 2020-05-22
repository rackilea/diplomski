private String filePath;

// ...

public void actionPerformed(ActionEvent e)
{
    JFileChooser chooser=new JFileChooser();
    int ret = chooser.showDialog(null, "Open file");
    if(ret == JFileChooser.APPROVE_OPTION)
    {
        File file = chooser.getSelectedFile();
        filePath = file.getPath();
    }
}