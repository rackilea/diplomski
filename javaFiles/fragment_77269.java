public void showAlertbox(String title) {
        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.alertbox_yes_no);
        dialog.setCanceledOnTouchOutside(false);
        TextView alertbox_title = (TextView) dialog
                .findViewById(R.id.alertbox_title);
        alertbox_title.setText(title);

        Button yes = (Button) dialog.findViewById(R.id.alertbox_yes);
        Button no = (Button) dialog.findViewById(R.id.alertbox_no);

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //code the functionality when YES button is clicked
            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //code the functionality when NO button is clicked
            }
        });

        dialog.show();
}