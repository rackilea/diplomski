LayoutInflater layoutInflater = LayoutInflater.from(YourActivity.this);
        View rootView = layoutInflater.inflate(R.layout.input_dialog, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(YourActivity.this);
        alertDialogBuilder.setView(rootView);

        final EditText yourEditText= (EditText) rootView .findViewById(R.id.edittext);

        alertDialogBuilder.setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                         // get the `EditText` value 
                         Toast.makeText(YourActivity.this,"EditText value" + yourEditText.getText(),Toast.LENG_SHORT).show();
                    }
                })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

        AlertDialog alert = alertDialogBuilder.create();
        alert.show();