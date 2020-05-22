public void showDialog() {
AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Results");
        builder.setCancelable(true);
        String s = "Time: " + time + " ns";
        builder
                .setMessage(s)
                .setCancelable(false)
                .setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MyActivity.this.finish();
                    }
                })
                .setNegativeButton("No",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }