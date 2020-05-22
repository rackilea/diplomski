AlertDialog.Builder builder = new AlertDialog.Builder(this);
    builder.setTitle("Delete entry")
        .setMessage("Are you sure you want to delete this entry?")
        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) { 
                // send data here with AsyncTask
            }
         })
        .setIcon(R.drawable.ic_my_icon);
    builder.setCancelable(false);
builder.show();