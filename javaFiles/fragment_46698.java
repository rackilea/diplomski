for (int i = 0; i < particularRadioGroup.getChildCount(); i++) {
    RadioButton childAt = (RadioButton) particularRadioGroup.getChildAt(i);
    boolean checked = childAt.isChecked();
    int id = childAt.getId();
    String text = childAt.getText().toString();
    // Save the Data of the RadioButton of the Particluar RadioGroup
    // Save Here
}