AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Bluetooth is not enabled...")
                .setCancelable(false)
                .setPositiveButton("Enable it!", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(getApplicationContext(), "Bluetooth enabled", Toast.LENGTH_LONG).show();
                                    ...
                    }
                })
                .setNegativeButton("Leave it!", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(getApplicationContext(), "Bluetooth still disabled", Toast.LENGTH_LONG).show();
                    }
                });
            AlertDialog mAlert = builder.create();
            mAlert.show();