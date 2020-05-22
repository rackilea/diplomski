public void setText(String labelText){
    mLabelText = labelText;
    if (label != null){
        label.setText(labelText);
    }
}