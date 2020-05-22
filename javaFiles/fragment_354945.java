package de.scrum_master.stackoverflow.q60461642;

public class Book {
  private String name;
  private String author;
  private double rating;
  private int purchases;

  public Book(String name, String author, double rating, int purchases) {
    this.name = name;
    this.author = author;
    this.rating = rating;
    this.purchases = purchases;
  }

  @Override
  public String toString() {
    return "Book{" +
      "name='" + name + '\'' +
      ", author='" + author + '\'' +
      ", rating=" + rating +
      ", purchases=" + purchases +
      '}';
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public double getRating() {
    return rating;
  }

  public void setRating(double rating) {
    this.rating = rating;
  }

  public int getPurchases() {
    return purchases;
  }

  public void setPurchases(int purchases) {
    this.purchases = purchases;
  }
}