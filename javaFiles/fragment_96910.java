builder.setItems(R.array.Stories, new DialogInterface.OnClickListener() {
    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        dismiss();
        mainActivity.getClicked(i);
    }
});