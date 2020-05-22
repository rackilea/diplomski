alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
    public void onClick(DialogInterface dialog,int which) {
        Toast.makeText(((Dialog) dialogInterface).getContext(), "You clicked on YES", Toast.LENGTH_SHORT).show();
    }
});

// Setting Negative "NO" Button
alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
    public void onClick(DialogInterface dialog, int which) {
        Toast.makeText(((Dialog) dialogInterface).getContext(), "You clicked on NO", Toast.LENGTH_SHORT).show();
        dialog.cancel();
    }
});