public void MyAddMethod<T>(ref List<T> list, T item)
{
    list.Add(item);
}

List<Book> book = new List<Book>();
Book myBook = new Book();
MyAddMethod(ref books, myBook);