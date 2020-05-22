AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
            builder1.setMessage("Write your message here.");
            builder1.setCancelable(true);
            builder1.setPositiveButton("Ok",
                    new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
            //put your code that needed to be executed when okay is clicked
            dialog.cancel();


            }
            });
            builder1.setNegativeButton("Cancel",
                    new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    dialog.cancel();
                }
            });

            AlertDialog alert11 = builder1.create();
            alert11.show();