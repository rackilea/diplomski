public static void main(String[] args) {

    Scanner kybd = new Scanner (System.in);
    Book [] books = new Book [10];

    // < is needed not >
    for (int i = 0; i < books.length; i++) 
    {
        // book[] is empty, it has an index of 10 with no nodes
        // You need to create the instance to pass into the method
        books[i] = getBook(kybd, new Book());
    }
}

// This should only take the book it is working with
public static Book getBook(Scanner kybd, Book book)
{
    System.out.println("What is the title of the next book?");
    String readTitle = kybd.nextLine();

    System.out.println("What is the title of the next book?");
    String readAuthor = kybd.nextLine();

    if (!readAuthor.isEmpty())
    {
        book.setTitle(readTitle);
    }

    if(!readTitle.isEmpty())
    {
        book.setAuthor(readAuthor);
    }

    return book;
}