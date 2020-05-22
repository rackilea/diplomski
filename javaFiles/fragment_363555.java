public void ShowDialog() {
    final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);

    alertDialog.setTitle("REMINDER!");
    alertDialog.setMessage("Turn off alarm by pressing off");

    alertDialog.setNegativeButton("Off", new DialogInterface.OnClickListener(){
        @Override
        public void onClick(DialogInterface dialog, int which) {
            Toast.makeText(getApplicationContext(), "OFF", Toast.LENGTH_SHORT).show();
        }
    });

    alertDialog.show();
    // line you have to add
    alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_TOAST);
}