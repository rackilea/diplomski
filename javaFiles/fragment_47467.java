if(rg1.getCheckedRadioButtonId()!=-1){
    int id= rg1.getCheckedRadioButtonId();
    View radioButton = rg1.findViewById(id);
    int radioId = radioGroup.indexOfChild(radioButton);
    RadioButton btn = (RadioButton) rg1.getChildAt(radioId);
    String selection = (String) btn.getText();
}