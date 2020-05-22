AlertDialog.Builder builder = new AlertDialog.Builder(this);
View view = getLayoutInflater().inflate(R.layout.dialog_layout, null);
builder.setView(view);
AlertDialog dialog = builder.create();

dialog.show();