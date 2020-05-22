public void onDelete(int Id) {
    if (usersListSend.size() > 0) {
        usersListSend.remove(Id);
    }

    Toast.makeText(context, "" + Id, Toast.LENGTH_SHORT).show();
}