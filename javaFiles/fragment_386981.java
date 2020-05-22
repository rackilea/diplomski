List<Marker> joinList = new ArrayList<>()

for(int i = 0; i<personList.size(); i++) {
    Person person = personList.get(i);
    for(int k = 0; k<booksList.size(); k++) {
        Book book = booksList.get(k);
        Book bookCopy = new Book();
        bookCopy.setName(book.getName);
        if(person.getName().equals("John" || k < 3) {                
            bookCopy.setReading(true);
        } else {
            bookCopy.setReading(false);
        }
        joinList.add(new Marker(person, bookCopy, k)); 
    }
}