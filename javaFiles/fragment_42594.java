public void getValues() {
        alertDialog = new AlertDialog.Builder(MainActivity.this);
        LayoutInflater inflater = this.getLayoutInflater();
        alertDialog.setView(inflater.inflate(R.layout.custom_layout, null));

        alertDialog.setCancelable(false);

        alertDialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                field1 = (EditText)((Dialog) dialog).findViewById(R.id.field1);
                field2 = (EditText)((Dialog) dialog).findViewById(R.id.field2);
                errorMsg = (TextView)((Dialog) dialog).findViewById(R.id.login_error);
                insert();
                continueWhereLeftOff();
            }
        });

        /* When negative (No/cancel) button is clicked*/
        alertDialog.setNegativeButton("Back", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel(); // Your custom code
                continueWhereLeftOff();
            }
        });
        alertDialog.show();
}


MyClass object = createObject();
if(!checkDB(object)){
    getValues();//Alert Dialog
}
else{
    continueWhereLeftOff();
}
//remove all code below this line to the continueWhereLeftOff()