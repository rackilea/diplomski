enum Edits {
    one(R.id.field1), two(R.id.field2);

    private int editTextId;

    Edits(int editTextId) {
        this.editTextId = editTextId;
    }

    EditText getEditText(Activity activity){
        return (EditText)activity.findViewById(editTextId);
    }
}