public void onDelete(int id) {
    if (id > -1 && id < usersListSend.size()) {
        usersListSend.remove(id);
    }

    Toast.makeText(context, "" + id, Toast.LENGTH_SHORT).show();
}