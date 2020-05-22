public void listBooks() {
    for(Inventory listBook : list) {

    System.out.println(listBook.getIsbn() + "\t"
                + listBook.getTitle() + "\t"
                + listBook.getYear() + "\t"
                + listBook.getAuthor() + "\t"
                + listBook.getPrice());
    }
}