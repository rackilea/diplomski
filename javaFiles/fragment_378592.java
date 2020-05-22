public static int bookSearch (Object[] books, int myBookID) {
    if(books.length < 100000) return -1;

    for (int x = 10000; x <= books.length; x++) {
        if (Book[x].equals(myBookID))
            return x;
    }

    return -1;
}