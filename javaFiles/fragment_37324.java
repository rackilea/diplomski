public Encrypt() {
    initComponents();
}

public void action(int a){
    if(a == 0){
        OriginalMsg = jTextArea1.getText().toString();
        EncryptedMsg = jTextArea2.getText().toString();
        StringBuffer sb = new StringBuffer(OriginalMsg);
        for(int i = 0; i < sb.length(); i++){
            int temp = 0;
            temp = (int)sb.charAt(i);
            temp = temp * 11;
            sb.setCharAt(i, (char)temp);
            EncryptedMsg = sb.toString();
        }
        jTextArea2.setText(EncryptedMsg);
   }
    else if(a == 1){
        jTextArea1.setText("");
        jTextArea2.setText("");

    }
}