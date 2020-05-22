public OnClickListener saveButtonListener = new OnClickListener() {
@Override
public void onClick(View v)
{
    // create info tags that match drop down activity
    if (infoText.getText().length() > 0 && infoText.getText().toString().matches(".*\\d+.*")
            && activityDropDown.getSelectedItem().toString().matches("Walking"))
    {
        addTaggedSearch(activityDropDown.getSelectedItem().toString() + " " + infoText.getText().toString()
                + " Miles");
        infoText.setText(""); // clear infoText
    }