AlertDialog.Builder builder = new AlertDialog.Builder(this);
    builder.setView(R.layout.test_hi);
    builder.setTitle("Test");
    builder.setCancelable(true);
    builder.setNeutralButton("TEST", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            Log.d("TAG","You clicked the TEST button of the dialog.");
        }
    });
    builder.show();