ImageButton ib = (ImageButton)findViewById(R.id.imageButton1);
final Context context = this;
ib.setOnClickListener(new View.OnClickListener() {

    @Override
    public void onClick(View v) {
         AlertDialog ad = new AlertDialog.Builder(context)
        .setMessage("Blah blah blah.\n Fine pring.\n Do you accept all our terms and conditions?")
        .setIcon(R.drawable.ic_launcher)
        .setTitle("Terms of Service")
        .setNeutralButton("back", this)
        .setCancelable(false)
        .create();

        ad.show();
    }
});