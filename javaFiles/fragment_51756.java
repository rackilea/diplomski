if(checkResult()) {
    Qcontent.setText(opsys.getString(0)); //this is to set the question I've taken from db to TextView
    a.setText(opsys.getString(1)); //this is to set the option A I've taken from db to radiobutton
    b.setText(opsys.getString(2)); //this is to set the option B I've taken from db to radiobutton
    c.setText(opsys.getString(3)); //this is to set the option C I've taken from db to radiobutton
    d.setText(opsys.getString(4)); //this is to set the option D I've taken from db to radiobutton
}