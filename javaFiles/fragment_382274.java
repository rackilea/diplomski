public class BrowseInputUI
{
    private JFileChooser fileopen = new JFileChooser();
    public BrowseInputUI()
    {
        int ret = fileopen.showDialog(null, "Provide a file");
        if(ret == JFileChooser.APPROVE_OPTION) File file = fileopen.getSelectedFile();
    }

    public String getPath()
    {
        return fileopen.getCurrentDirectory();
    }
}