JFileChooser instance = new JFileChooser()
{
    protected JDialog createDialog(Component parent) throws HeadlessException
    {
        JDialog dialog = super.createDialog(parent);
        dialog.setModalityType(ModalityType.DOCUMENT_MODAL);
        return dialog;
    }
};
instance.addActionListener(new ActionListener()
{
    public void actionPerformed(ActionEvent e)
    {
        if (JFileChooser.APPROVE_SELECTION.equals(e.getActionCommand()))
        {
            File file = ((JFileChooser)e.getSource()).getSelectedFile();
            //loadFromFile(file); // My custom function for loading from a File
        }
    }
});
instance.showOpenDialog(this);