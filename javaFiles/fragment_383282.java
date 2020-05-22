public static void main(String[] args)
{
    DirectoryDialog dialog = new DirectoryDialog(new Shell());

    String path = dialog.open();

    if(path != null)
    {
        Program.launch(path);
    }
}