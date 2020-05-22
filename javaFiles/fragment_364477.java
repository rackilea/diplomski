private Handler mTimerHandler = new Handler();
private ProgressDialog mProgressDialog = null;
private Button Root;


@Override
protected void onCreate(Bundle savedInstanceState) {

    ...........

    Root = (Button) findViewById(R.id.Root);
    Root.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View arg0) {

            mProgressDialog = ProgressDialog.show(MainActivity.this, "", "Please wait...", true);

            mTimerHandler.postDelayed(mTimerExecutor, 5000);
        }
    });

    ...........

}


private Runnable mTimerExecutor = new Runnable() {

    @Override
    public void run() {

        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
        }

        showDialog();
    }
};

private void showDialog() {

    if (RootTools.isAccessGiven()) {

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setIcon(R.drawable.ic_launcher);
        builder.setTitle("Congratulations!");
        builder.setMessage("You Have Root Access!");

        builder.setPositiveButton("OKAY", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();

    } else {

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setIcon(R.drawable.ic_launcher);
        builder.setTitle("Oops!");
        builder.setMessage("No Root Access!");
        builder.setPositiveButton("OKAY", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.cancel();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();  
    }

}