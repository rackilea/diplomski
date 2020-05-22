add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater = LayoutInflater.from(mainscreen.this);
                View promptView = layoutInflater.inflate(R.layout.promptexercise, null);
                AlertDialog.Builder alertdialog = new AlertDialog.Builder(mainscreen.this);
                alertdialog.setView(promptView);
// here use findviewby id from your inflated view like this!
                final EditText e1 = (EditText) promptView.findViewById(R.id.editText);
                alertdialog.setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                    String newEntry9 = e1.getText().toString();
                                    if (e1.length() != 0) {
                                        AddExerData(newEntry9);
                                        e1.setText("");
                                    } else {
                                        toastMessage("You must enter an exercise name in the field!");
                                    }
                                    Toast.makeText(mainscreen.this), newEntry9, Toast.LENGTH_SHORT).show();


                                }

                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                alertdialog.create();
                alertdialog.show();

            }
        });