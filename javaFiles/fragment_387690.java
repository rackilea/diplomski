AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
alertDialogBuilder.setTitle("Result");
alertDialogBuilder
        .setMessage("\nڕیكه‌وت : " + year + "/" + month + "\n\nكۆی خه‌رجی : " + a + "\n\nكۆی نرخی : " + b + " دینار")
        .setCancelable(false)
        .setPositiveButton("Send Result",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        // Will create a share picker to share the text among applications installed in your phone
                        Intent sendIntent = new Intent();
                        sendIntent.setAction(Intent.ACTION_SEND);
                        sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
                        sendIntent.setType("text/plain");
                        startActivity(sendIntent);

                    }
                })

        .setNegativeButton("Done", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

                dialog.cancel();
            }
        });

AlertDialog alertDialog = alertDialogBuilder.create();
alertDialog.show();