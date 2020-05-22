List<Book> list1 = Arrays.asList(
        new Book("To - jest haha"),
        new Book("Bubû"),
        new Book("Kiki"),
        new Book("bam 2"),
        new Book("sza . lä"));
List<Book> list2 = Arrays.asList(
        new Book("Tojest haha"),
        new Book("bam 1"),
        new Book("zzz"),
        new Book("száLa"));
System.out.println(countBooksByTitle(list1, list2));