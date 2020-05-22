//Dialog box creator
private Dialog constructYourDialog()
{
    //Preparing views
  LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
  View layout = inflater.inflate(R.layout.***your_xml_name***, (ViewGroup) findViewById(R.id.***Yout view id***));
    //Building dialog
    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    builder.setView(layout);

    builder.setPositiveButton("Show Videos", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
                Log.i("","Show Video Click");
                dialog.dismiss();
    });
    builder.setNegativeButton("E-Mail", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
           Log.i("","E-mail Click");
           dialog.dismiss();
        }
    });
     builder.setNeutralButton("Show Map", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            Log.i("","Show Map Click");
            dialog.dismiss();
        }
    });
          AlertDialog alert = builder.create();
    return alert;

}