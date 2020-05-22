private class Picture implements ActionListener
{
    public void actionPerformed(ActionEvent event)
    {
        fc = new JFileChooser();
        FileNameExtensionFilter picture = new FileNameExtensionFilter("JPEG files (*.png)", "png");
        fc.setFileFilter(picture);
        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        if (fc.showDialog(Notepad.this, "Insert")!=JFileChooser.APPROVE_OPTION)  return;
        filename = fc.getSelectedFile().getAbsolutePath();

        // If no text is entered for the file name, refresh the dialog box
        if (filename==null) return;

        try 
        {
            BufferedImage img = ImageIO.read(new File(filename));
            ImageIcon pictureImage = new ImageIcon(img);
            textArea.insertIcon(pictureImage);
        } 

        catch (IOException e) 
        {
            JOptionPane.showMessageDialog(frame, "Could not find file: " + filename);
        }
    }
}