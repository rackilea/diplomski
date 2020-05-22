// First, set onCheckChangeListener into your RadioGroup
radio_g.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
{
    public void onCheckedChanged(RadioGroup rGroup, int checkedId)
    {
       // find view for both radio buttons
        RadioButton rb1 = (RadioButton)rGroup.findViewById(R.id.newoption);
        RadioButton rb2 = (RadioButton)rGroup.findViewById(R.id.usedoption);


        if (rb1.isChecked()) {
            SelectedType = rb1.getText().toString(); // set text into SelectedType 
        } else if (rb2.isChecked()) {
            SelectedType = rb2.getText().toString();
           }

    }
});