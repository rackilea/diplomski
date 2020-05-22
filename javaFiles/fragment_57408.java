public BookInformation initializeUserInfos(String str){
    System.out.println(str);
    String[] bookCellArray=str.split("     ");

    // create and use a local BookInformation variable and object:
    BookInformation bInfos = new BookInformation(); // *****

    bInfos.setBookName(bookCellArray[0]);
    bInfos.setBookDate(bookCellArray[1]);
    bInfos.setBookID(bookCellArray[2]);
    return bInfos;
}