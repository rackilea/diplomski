class Book implements Serializable {
    private String title;
    private String author;

    public Book() {
    }

    public Book(String title, String author) {
        super();
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book [title=" + title + ", author=" + author + "]";
    }

}

public class Snippet {
    public static void main(String[] args) {
        List<Book> list = Arrays.asList(new Book("book1", "author1"), new Book("book2", "author2"),
                new Book("book3", "author3"));
        writeFile("C:\\books", list);
        List<Book> list2 = readFile("C:\\books", list);
        list2.forEach(System.out::println);
    }

    public static List<Book> readFile(String filename, List<?> arrayname) {

        File file = new File(filename + ".ser");
        try {

            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);

            List<Book> books = (List<Book>) ois.readObject();

            ois.close();
            fis.close();

            return books;
        } catch (IOException i) {
            System.out.println("The file " + file.getPath() + " was not found.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void writeFile(String filename, List<Book> arrayname) {

        File file = new File(filename + ".ser");

        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(arrayname);

            oos.close();
            fos.close();

        } catch (IOException i) {
            System.out.println("The file " + file.getPath() + " was not found.");
        }

    }