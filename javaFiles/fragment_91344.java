String selection = ContactsContract.CommonDataKinds.Email.DATA
    + " NOT LIKE ''";
if (constraint != null) {
    selection += " AND " + ContactsContract.CommonDataKinds.Email.DATA + " LIKE ?";
}
cl = new CursorLoader(getApplicationContext(), 
    ContactsContract.CommonDataKinds.Email.CONTENT_URI,
    PROJECTION, selection, constraint, sortOrder);