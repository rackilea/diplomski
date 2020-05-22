public Message someMethod(String id1, String id2) {
    for (String id: Arrays.asList(id1, id2)) {
        if (Dao.findUser(id) == null) {
            return createMessage("Error", Enum.Error, id);
        }
    }
    // Do stuff after verifying users exists
    return createMessage("All OK", Enum.OK, messageData);
}