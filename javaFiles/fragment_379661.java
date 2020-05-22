public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {

        List<Book> listOfBooks = new ArrayList<Book>();
        Book bk1 = new Book();
        listOfBooks.add(bk1);

        System.out.println("           bk1 = " + bk1);
        System.out.println("listOfBooks(0) = " + listOfBooks.get(0));

    }

    public class Book {

        String name;
        int pages;
        String auother;
        boolean available;
        String rentername;

        @Override
        public String toString() {
            return "Book: name = " + name + "; pages = " + pages + "; available = " + available + "; rentername = " + rentername + "; hashCode = " + hashCode();
        }

    }
}