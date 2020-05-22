btnEdi.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent ae) {
        File pdfFile = new File(txtText.getText());                
        try {
            Desktop.getDesktop().open(pdfFile));
        } catch (IOException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog( null
                                         , "An error happened trying to open file : " + pdfFile.getPath()
                                         , "IOException"
                                         , JOptionPane.WARNING_MESSAGE
            );
        }
    }
});