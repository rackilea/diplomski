public class LinkOkPressed implements ActionListener
{
    JLabel test;
    @Override
    public void actionPerformed(ActionEvent e)
    {
        // ImageDownloader is a class I have created, that simply saves the image
        // from the given URL in a predetermined directory
        ImageDownloader.saveImage(ImageDownloader.getImageUrl(AdditionPanel.textpane.getText()));
        ImageIcon poster = new ImageIcon(getClass().getResource("/resources/myimage.png"));
        test= new JLabel(poster);
        Object obj = e.getSource(); // "obj" is really "linkOk" from class "AdditionPanel"
        java.awt.Container parent = ((JButton) obj).getParent(); // "parent" is instance of "AdditionPanel"
        ((JPanel) parent).add(test);
    }
}