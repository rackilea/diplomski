KeyListener kl = new KeyAdapter(){
    public void keyTyped(KeyEvent evt)){
        if(yourTextField.getText().equals(yourString){
            //do something here
        }
    }
};
yourTextField.addKeyListener(kl);