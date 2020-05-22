MaterialDialog dialog = new MaterialDialog.Builder(this)
                    .title("Edit Paid Amount")
                    .customView(R.layout.edit_payment_model, true)
                    .positiveText("Update Payment")
                    .build();

    View customView = dialog.getCustomView();
    Spinner spinner = (Spinner) customView.findViewById(R.id.spinner)
    EditText editText = (EditText) customView.findViewById(R.id.editPaymentAmount);
    editText.setText("test label");
    dialog.show();