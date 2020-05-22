package de.scrum_master.stackoverflow.q60461642;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Application {
  private static List<Book> books = Arrays.asList(
    new Book("The Nickel Boys", "Colson Whitehead", 4.3, 500000),
    new Book("Olive, Again", "Elizabeth Strout", 6, 321000),
    new Book("Gingerbread", "Helen Oyeyemi", 2, 681000),
    new Book("On Earth We're Briefly Gorgeous", "Ocean Vuong", 2, 421000),
    new Book("Perfume", "Patrick Süskind", 6, 500000)
  );

  public static void main(String[] args) {
    printBooks();
    findBooksByNumberOfPurchases();
  }

  private static void printBooks() {
    System.out.println("Books list:");
    books.stream().forEach(System.out::println);
    System.out.println("\n");
  }

  private static void findBooksByNumberOfPurchases() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the number of purchases to search for:");
    int input = scanner.nextInt();
    books.stream()
      .filter(book -> book.getPurchases() == input)
      .forEach(System.out::println);
  }
}