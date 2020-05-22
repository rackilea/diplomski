//was R.string.accept 
alertDialog.setNegativeButton(getString(R.string.decline), new DialogInterface.OnClickListener() {
    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        Activity.this.finish();
    }
});
                                  //was R.string.decline
alertDialog.setPositiveButton(getString(R.string.accept), new DialogInterface.OnClickListener() {
    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        // handle accepting
    }
});