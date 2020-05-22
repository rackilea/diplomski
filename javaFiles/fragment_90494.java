if(!isEmpty())
{
    while(!theBook.bookName.equals(bookName))
    {
        if(theBook.next == null)
        {
            return null;
        }
        else
        {
            theBook = theBook.next;
        }
    }
}
else
{
    System.out.println("Our Library is empty");
}