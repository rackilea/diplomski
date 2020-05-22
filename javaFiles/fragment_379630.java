class YourClass
{
    dbproperties db = new dbproperties();

    public static void main(String[] args)
    {
        [...]
        Chunk text1 = new Chunk(db.index_number);
        Paragraph p = new Paragraph();
        p.add(text1);
        document.close();
        [...]
    }
}