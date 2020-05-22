@Test
    public void batra() throws Exception {
        List<Book> books = new ArrayList<Book>();

        // this where you're logic in populating the books list goes.
        Book book1 = new Book("Software Craftmanship", "Pete McBreen", "26");
        Book book2 = new Book("Chad Fowler", "The Passionate Programmer", "16");
        Book book3 = new Book("Core Java", "O'Reilly", "11");

        Book book2Child1 = new Book("Software Craftmanship", "", "26");
        Book book2Child2 = new Book("Agile Development", "", "32");
        Book book2Child3 = new Book("Continuous Delivery", "", "41");

        book2.addToChildren(book2Child1);
        book2.addToChildren(book2Child2);
        book2.addToChildren(book2Child3);

        books.add(book1);
        books.add(book2);
        books.add(book3);

        ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        System.out.print(mapper.writeValueAsString(books));
    }