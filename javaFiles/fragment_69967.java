public class BookData {

private String bookNo;
private String bookName;

BookData(String bookNo, String bookName){
    this.bookNo = bookNo;
    this.bookName = bookName;
}

public String getBookNo() {
    return bookNo;
}

public void setBookNo(String bookNo) {
    this.bookNo = bookNo;
}

public String getBookName() {
    return bookName;
}

public void setBookName(String bookName) {
    this.bookName = bookName;
} }