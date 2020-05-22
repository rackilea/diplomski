private boolean userExists() {
    String username = nomUtilisateur.getText().toString();
    String password = motPasse.getText().toString();

    Cursor users = userProvider.query(MyUserProvider.CONTENT_URI,
            null,
            " WHERE username = " + nomUtilisateur.getText().toString() +
            " AND password = " + motPasse.getText().toString(), null, null);

    if (users.getCount() != 0) {
        return true;
    } else {
        return false;
    }
}