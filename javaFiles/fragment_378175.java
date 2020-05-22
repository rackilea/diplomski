AlertDialog.Builder builder = new AlertDialog.Builder(this,R.style.MyCustomThemeForAlertDialog);
builder.setCancelable(false);
builder.setTitle("Title");
builder.setMessage("Do you want to Quit?");
builder.setPositiveButton("OK", null);
builder.setNegativeButton("Cancel", null);

AlertDialog dialog = builder.create();
dialog.show();