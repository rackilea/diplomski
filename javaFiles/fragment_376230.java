public void ChkCommand(View v)
{
    String value="";
    txtans = (EditText)findViewById(R.id.txtcon1);

    if(chkBox1.isChecked())
    {
        /*((CheckBox) findViewById(R.id.chk3)).setChecked(false);
        ((CheckBox) findViewById(R.id.chk2)).setChecked(false);*/
        chkClick = (CheckBox) findViewById(R.id.chk1);
        value += chkClick.getText().toString()+", ";

    }
    if(chkBox2.isChecked())
    {
        /*((CheckBox) findViewById(R.id.chk1)).setChecked(false);
        ((CheckBox) findViewById(R.id.chk3)).setChecked(false);*/
        chkClick = (CheckBox) findViewById(R.id.chk2);
        value += chkClick.getText().toString()+", ";
    }
    if(chkBox3.isChecked())
    {/*
        ((CheckBox) findViewById(R.id.chk1)).setChecked(false);
        ((CheckBox) findViewById(R.id.chk2)).setChecked(false);*/
        chkClick = (CheckBox) findViewById(R.id.chk3);
        value += chkClick.getText().toString();
    }

    txtans.setText(value);
}