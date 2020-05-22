public class Book {
    private String name;
    private int copy;


    public Book() {

    }

    //Add this constructor, and keep the empty constructor too

    public Book(String name, int copy) {
        this.name = name;
        this.copy = copy;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCopy(int copy) {
        this.copy = copy;
    }

    public String getName() {
        return name;
    }

    public int getCopy() {
        return copy;
    }
}