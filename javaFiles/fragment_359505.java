//listener classes for the addItemFrame 
class goBackListener implements ActionListener{
    private addItemFrame frame;
    public goBackListener(addItemFrame frame){
        this.frame= frame;
    }
    public void actionPerformed(ActionEvent event){
        frame.dispose();
    }
}