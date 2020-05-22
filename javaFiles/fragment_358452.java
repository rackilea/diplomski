private void showDialog(Stores store)
    {
        Intent intent = new Intent(this,DisplayDialogActivity.class);
        intent.putExtra("Locations",store);
        startActivityForResult(intent, 0);
    }