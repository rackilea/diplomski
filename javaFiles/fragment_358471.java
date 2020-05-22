AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(mActivity);
    LayoutInflater inflater = mActivity.getLayoutInflater();
    final View dialogView = inflater.inflate(R.layout.dialog, null);
    dialogBuilder.setView(dialogView);

final EditText mEditText = (EditText) dialogView.findViewById(R.id.editTextField);

dialogBuilder.setTitle("Title");
dialogBuilder.setMessage("Type your message here");

dialogBuilder.setPositiveButton("Yes", null);
dialogBuilder.setNegativeButton("No", null);

final AlertDialog alertDialog = dialogBuilder.create();
alertDialog.setOnShowListener(new DialogInterface.OnShowListener() {

    @Override
    public void onShow(DialogInterface dialog) {
        Button positiveButton = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
        positiveButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String enteredTextString= mEditText.getText().toString();
                //To whatever with the text entered
            }
        });
        Button negativeButton = alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE);
        negativeButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });
    }
});
alertDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
    @Override
    public void onDismiss(DialogInterface dialog) {

    }
});
alertDialog.show();