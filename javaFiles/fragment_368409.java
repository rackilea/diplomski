@FXML
private  Button btnYes;
private boolean btnYesStatus = false;

@FXML
private void handelYesBtn(){
    this.setBtnYesStatus(true);
    this.close();
}

public void setBtnYesStatus(boolean btnYesStatus) {
    this.btnYesStatus = btnYesStatus;
    System.out.println(btnYesStatus);
} 

public boolean isBtnYesStatus() {
    return btnYesStatus;   
}