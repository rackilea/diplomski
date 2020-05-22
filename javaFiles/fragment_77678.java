AlertDialog.Builder builder = new AlertDialog.Builder(NastavenieCasu.this); 
builder.setTitle("hi");
builder.setItems(items, new DialogInterface.OnClickListener() {
    public void onClick(DialogInterface dialog, int which) {
        // 
        // do something
    }

AlertDialog alertDialog = builder.create();
alertDialog.show();