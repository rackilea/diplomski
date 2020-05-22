ArrayList<JCheckBox> checkboxes  = new ArrayList<JCheckBox>();
//Init your checkboxes array. 

for(JCheckbox chkbox :checkboxes)
{
  if(chkbox.isSelected())
   {
    actual = chkbox.getText() ; break;
  }
}