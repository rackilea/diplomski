public void showMyCustomDialog(Context context, String title, String message)
    {
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //tell the Dialog to use the customalertdialog.xml as it's layout description
        dialog.setContentView(R.layout.customalertdialog);
        TextView titleText = (TextView) dialog.findViewById(R.id.txtTitleAlertDialog);
        titleText.setText(title);
        TextView txt = (TextView) dialog.findViewById(R.id.txtAlertDialog);
        txt.setText(message);
        Button dialogButton = (Button) dialog.findViewById(R.id.buttonAlertDialogCancel);
        dialogButton.setText("OK");
        dialogButton.setOnClickListener(new View.OnClickListener() 
        {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }