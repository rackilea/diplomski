public class Book {

private static int counter=1;

private int number;
private String author;
private String title;
private String code;
private int pages;
private static int multiplier = 15;

public Book(String author, String title, String code, int pages, int number) {
    this.number = counter;
    this.author = author;
    this.title = title;
    this.code = code;
    this.pages = pages;
    counter++;
}