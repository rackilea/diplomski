class MenuActionListener3 implements ActionListener {   
    MPUChecker menu3mC = new mpuChecker();

    public void actionPerformed(ActionEvent e)
    {
        menu3mC.CheckMpu(path, textField.getText(),1);
        setVisible(false);
    }
}