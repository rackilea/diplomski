import java.util.*;
import com.thoughtworks.xstream.*;
import com.thoughtworks.xstream.io.*;
import com.thoughtworks.xstream.io.xml.*;
import java.io.*;

public class Test {

    public static void main(String[] args) throws Exception {

        XStream xstream = new XStream(new DomDriver());
        xstream.alias("ListOfDBook", ListOfDBook.class);
        xstream.alias("DBook", DBook.class);
        xstream.alias("Authors", Authors.class);
        xstream.alias("DAuthor", DAuthor.class);
        xstream.addImplicitCollection(Authors.class, "dauthors");
        xstream.addImplicitCollection(DBook.class, "authors");
        xstream.addImplicitCollection(ListOfDBook.class, "dbooks");
        InputStream in = new FileInputStream("Books.xml");
        ListOfDBook var = (ListOfDBook)xstream.fromXML(in);

    }

}

//ListOfDBook.java
class ListOfDBook {
    public List<DBook> dbooks = new LinkedList<DBook>(); 
}

//DBook.java
class DBook {
    public List<Authors> authors = new LinkedList<Authors>();
}

//Authors.java
class Authors {
    public List<DAuthor> dauthors = new LinkedList<DAuthor>();
}

//DAuthor.java
class DAuthor {
    public String Name;
    public String Url;
}