Dialog dialog;

private void showDialog() {
    // custom dialog
    dialog = new Dialog(this);
    dialog.setContentView(R.layout.custom_dialog);

    // set the custom dialog components - text, image and button
    ImageButton close = (ImageButton) dialog.findViewById(R.id.btnClose);
    Button buy = (Button) dialog.findViewById(R.id.btnBuy);

    // Close Button
    close.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            dialog.dismiss();
            //TODO Close button action
        }
    });

    // Buy Button
    buy.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            dialog.dismiss();
            //TODO Buy button action
        }
    });

    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

    dialog.show();
}