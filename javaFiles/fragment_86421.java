Iterator<Map.Entry<String, Book>> iter = books.entrySet().iterator();
while (iter.hasNext())
{
    Map.Entry<String, Book> entry = iter.next();
    if ( entry.getKey().matches("(.+_){2,}unknown.*") )
    {
        iter.remove();
    }
}