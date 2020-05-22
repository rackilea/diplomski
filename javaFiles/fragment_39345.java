final Dialog dialog = new Dialog(activity);
    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
    dialog.setCancelable(false);
    dialog.setContentView(R.layout.dialog);

    TextView text = (TextView) dialog.findViewById(R.id.text_dialog);
    text.setText(msg);

    Button dialogButton = (Button) dialog.findViewById(R.id.btn_dialog);
    dialogButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            dialog.dismiss();
        }
    });

    dialog.show();