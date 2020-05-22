addButton.setOnAction((event)->{
    data.add(new Book(String.valueOf(newBookIndex),"test"));

    lv.lookupAll(".indexed-cell").stream()
            .map(n->(BookCell)n)
            .filter(c->c.getBook().getIsbn().equals(String.valueOf(newBookIndex)))
            .findFirst().ifPresent(BookCell::runAnimation);
    newBookIndex++;
});