final EditText editText;

            final AlertDialog.Builder alert = new AlertDialog.Builder(DemoActivity.this);
                       alert.setTitle("Enter a name");
             alert.setMessage("Enter student Name");
            alert.setCancelable(false);


            editText = new EditText(DemoActivity.this);
            alert.setView(editText);
            alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int whichButton) {

                }
            });

            alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int whichButton) {

                }
            });

            final AlertDialog dialogs  = alert.create();
            dialogs.show();

            dialogs.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String value = editText.getText().toString();
                    if (value.isEmpty()) {
                        editText.setError("Please enter student name");
                    }
                    else{
                        dialogs.dismiss();
                    }

                }
            });

            dialogs.getButton(AlertDialog.BUTTON_NEGATIVE).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    dialogs.dismiss();
                }
            });