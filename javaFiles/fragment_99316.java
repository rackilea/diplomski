@Override
public void actionPerformed(ActionEvent event) {
    if(event.getSource()==setup){
        yourProcess();
        JOptionPane.showMessageDialog(null, "Everything fine!");
    }
}