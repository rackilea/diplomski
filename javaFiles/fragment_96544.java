class ExitHandler implements ActionListener{
    public void actionPerformed(ActionEvent e) {
        int n = JOptionPane.showConfirmDialog(frame1, 
                "Are you sure you want to exit?", "Exit?",JOptionPane.YES_NO_OPTION);
        if(n == JOptionPane.YES_OPTION){
            System.exit(0);
            System.out.println("EXIT SUCCESSFUL");
        }
    }
}