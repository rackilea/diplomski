private void setTheField(){
    char[] temp = new char[3];
    String id=jTextField1.getText();
    if(id.length()>0);
        temp[0]=id.charAt(0);
    String name=jTextField2.getText();
    if(name.length()>0);
        temp[1]=name.charAt(0);
    String type=jTextField3.getText();
    if(type.length()>0);
        temp[2]=type.charAt(0);
    jTextField4.setText(new String(temp)); //Output text Field
}