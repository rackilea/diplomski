public Dialog onCreateDialog() {
    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    // Get the layout inflater
    LayoutInflater inflater = this.getLayoutInflater();
    Log.i("INFO","Creating Dialog...");
    View view = inflater.inflate(R.layout.goaldialog, null);
    // Inflate and set the layout for the dialog
    // Pass null as the parent view because its going in the dialog layout
    builder.setView(view)
            // Add action buttons
            .setPositiveButton(R.string.SetAGoalButton, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int id) {
                    EditText et = (EditText)view.findViewById(R.id.GoalChooser);
                    Integer goalNumber = Integer.parseInt(et.getText().toString());
                    globalVariable = goalNumber;
                    Log.i("INFO",Integer.toString(goalNumber));
                    dialog.dismiss();
                }
            })
            .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    dialog.dismiss();
                }
            });
    builder.show();
    return builder.create();
}