private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)   {                                         

    try{
        setFName(jTextField1.getText());
        setLName(jTextField2.getText());
        boolean firstNameHasDigit = havedigit(getFName());
        boolean lastNameHasDigit = havedigit(getLName());
        if (firstNameHasDigit || lastNameHasDigit) {
            jLabel6.setText("Names cannot contain digits");
        }
        else {
            WriteToFile(getFName());
            WriteToFile(getLName());
            setDate(Integer.parseInt(jTextField3.getText()));
            WriteToFile(String.valueOf(getDate()));
            Random rnd1=new Random();
            Registration_Number=rnd1.nextInt(100);
            setRegNum(Registration_Number);
            WriteToFile(String.valueOf(getRegNum()));
            jLabel6.setText(String.valueOf(getRegNum()));
        }
    }
    catch(Exception e){
        jLabel6.setText("Error!");
    }
}                                        

public boolean havedigit(String in){
    for(int i=0;i<in.length();i++){
        if(Character.isDigit(in.charAt(i)))  return true;
    }
    return false;
}