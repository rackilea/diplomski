public static int bookSearch (Object[] Book, int numOfBooks, int myBookID) {
    for (int x = 10000; x <= numOfBooks; x ++) {
        if (Book[x].equals(myBookID))
            return x;
    }

    return -1;
}