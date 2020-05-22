public class Book{
    public String title;
    public int sameTitle(String bookTitle) {
        return this.title.compareTo(bookTitle);
    }
}

public static Book getBook(Book [] A, int left, int right, String bookTitle) { //binary search
    int middle;

    while (left <= right) {
        //If middle item == 0, returns true
        middle = (left + right)/2;
        int compare = A[middle].sameTitle(bookTitle);
        if (compare == 0) {
            return A[middle];
        } else {
            if (compare >0) {
                right = middle -1;
            } else {
                left = middle + 1;
            }
        }
    }
    return null;
}

// example use of getting and using the book
Book b = getBook(...);
if (b != null){
    System.out.println("Success! you found the book " + b);
}