public static void main(String[] args) throws SQLException {
        List<MyDataType> listOfElements = retrieveFromDB();
        MyListHandler myListHandler = new MyListHandler(listOfElements);
        myListHandler.printList();
        myListHandler.clearList();
    }