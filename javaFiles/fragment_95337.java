import java.util.ArrayList;
import java.util.List;

public class Book {
    private final String name;
    private final String author;
    private final String cost;

    private final List<Book> children = new ArrayList<>();

    public Book(String name, String author, String cost) {
        this.name = name;
        this.author = author;
        this.cost = cost;
    }

    public void addToChildren(Book book) {
        children.add(book);
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getCost() {
        return cost;
    }

    public List<Book> getChildren() {
        return children;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((author == null) ? 0 : author.hashCode());
        result = prime * result + ((children == null) ? 0 : children.hashCode());
        result = prime * result + ((cost == null) ? 0 : cost.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Book other = (Book) obj;
        if (author == null) {
            if (other.author != null)
                return false;
        } else if (!author.equals(other.author))
            return false;
        if (children == null) {
            if (other.children != null)
                return false;
        } else if (!children.equals(other.children))
            return false;
        if (cost == null) {
            if (other.cost != null)
                return false;
        } else if (!cost.equals(other.cost))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Book [name=" + name + ", author=" + author + ", cost=" + cost + ", children=" + children + "]";
    }


}