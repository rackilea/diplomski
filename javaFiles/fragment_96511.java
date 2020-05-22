buildNot.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
    @Override
    public void onClick(DialogInterface dialog, int which) {
        adapter = (ArrayAdapter ) list.getAdapter();
        String item = (String) adapter.getItem(mPosition);
        item += "YourText";
        adapter.insert(item, mPosition);
        dialog.cancel();
    }
});