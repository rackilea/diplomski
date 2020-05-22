AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
alertDialog.setTitle("Values");
final EditText oldPass = new EditText(MainActivity.this);
final EditText newPass = new EditText(MainActivity.this);
final EditText confirmPass = new EditText(MainActivity.this);


oldPass.setTransformationMethod(PasswordTransformationMethod.getInstance());
newPass.setTransformationMethod(PasswordTransformationMethod.getInstance());
confirmPass.setTransformationMethod(PasswordTransformationMethod.getInstance());

oldPass.setHint("Old Password");
newPass.setHint("New Password");
confirmPass.setHint("Confirm Password");
LinearLayout ll=new LinearLayout(MainActivity.this);
ll.setOrientation(LinearLayout.VERTICAL);

ll.addView(oldPass);

ll.addView(newPass);
ll.addView(confirmPass);         
alertDialog.setView(ll);
alertDialog.setPositiveButton("Yes",
        new DialogInterface.OnClickListener() {
    public void onClick(DialogInterface dialog, int id) {
        dialog.cancel();
    }
});
alertDialog.setNegativeButton("No",
        new DialogInterface.OnClickListener() {
    public void onClick(DialogInterface dialog, int id) {
        dialog.cancel();
    }
});

AlertDialog alert11 = alertDialog.create();
alert11.show();