public String searchTitle(String titleSearch) {

    if(collection.stream().anyMatch(book->{return titleSearch.equalsIgnoreCase(book.getTitle());})){
        return "\n Book Avaliable";
    }
    else{
        return "\n No Books Avaliable";
    }
}