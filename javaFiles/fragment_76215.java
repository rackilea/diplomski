public void setLabel(View v) {
    v.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);

    final Button button = (Button) v;
    final EditText input = new EditText(this);

    new AlertDialog.Builder(this)
        .setMessage("Add label:")
        .setView(input)
        .setPositiveButton("Set", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                if (input.getText() == null || input.getText().toString().length() == 0) {
                    Toast.makeText(AlarmDialog.this, Html.fromHtml("<i>" + getString(R.string.label_reset) + "<i>"), Toast.LENGTH_SHORT).show();
                    button.setText(R.string.label);
                }
                else {
                    alarmLabel = input.getText().toString();
                    Toast.makeText(AlarmDialog.this, Html.fromHtml("<b>" + getString(R.string.label_set) + "<b>"), Toast.LENGTH_SHORT).show();
                    button.setText(R.string.label_set);
                }

            }
        })
        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                Toast.makeText(AlarmDialog.this, Html.fromHtml("<i>" + getString(R.string.label_not_set) + "<i>"), Toast.LENGTH_SHORT).show();
            }
        }).create().show();
}