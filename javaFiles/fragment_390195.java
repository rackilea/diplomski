private Provider provider = new Provider();

public Your_Class_Name(){
    provider.setClosable(true);
}

private void Cash_ButtonActionPerformed(java.awt.event.ActionEvent evt) {
    if(provider.isVisible()) return;
    MainMenu.add (provider);
}