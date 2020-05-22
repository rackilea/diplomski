@Override
protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

    if(requestCode == ADD_ENTRY_REQUEST && resultCode == RESULT_OK){
        ...

    }else if(requestCode == EDIT_ENTRY_REQUEST && resultCode == RESULT_OK){
        int id = Objects.requireNonNull(data).getIntExtra(AddEditEntry.EXTRA_ID, -1);

        if (id == -1){
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show();
            return;
        }

        ...

    }else{Toast.makeText(this, "Entry not added!", Toast.LENGTH_SHORT).show();}
}