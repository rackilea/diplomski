@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    showDialog(YOUR_DIALOG_ID);
}

@Override
protected Dialog onCreateDialog(int id) {
    switch(id) {
    case YOUR_DIALOG_ID:
        return new AlertDialog.Builder(LeakedDialogActivity.this)
        .setIcon(android.R.drawable.ic_dialog_alert)
        .setMessage("This dialog leaks!")
        .setTitle("Leaky Dialog")
        .setCancelable(false)
        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {}
        })
        .create();
    }
    return super.onCreateDialog(id);
}