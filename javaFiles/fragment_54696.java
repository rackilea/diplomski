cursorAdapter.setFilterQueryProvider(new FilterQueryProvider() {

    public Cursor runQuery(CharSequence constraint) {
        return changedAppoint.getChanges(constraint.toString());
    }
});