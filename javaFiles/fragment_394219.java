//ListOfDBook.java
public class ListOfDBook {
    public ArrayList<DBook> DBook; 
}

//DBook.java
public class DBook {
    public ArrayList<Author> Authors;
}

//Author.java
public class Author {
    public ArrayList<DAuthor> DAuthors;
}

//DAuthor.java
public class DAuthor {
    String Name;
    String Url;
}