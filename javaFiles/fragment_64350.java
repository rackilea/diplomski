private boolean userExists() {
    String username = nomUtilisateur.getText().toString();
    String password = motPasse.getText().toString();
    String[] selection = {username, password};

    Cursor users = getApplicationContext().getContentResolver().query
            (Agenda.UserEntry.CONTENT_URI,
            null,
            "username = ? AND password = ?", selection, null);

    if (users.getCount() != 0) {
        return true;
    } else {
        return false;
    }
}