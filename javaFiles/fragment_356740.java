AlertDialog alert = new AlertDialog.Builder(this).create();
    alert.setTitle("Error");
    alert.setMessage("Sorry, your device does not support flashlight.");
    ADB.setNeutralButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            finish();
            }
        });
    alert.show();