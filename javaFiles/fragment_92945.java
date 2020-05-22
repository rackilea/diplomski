package de.scrum_master.app;

public class Application {
    public static void main(String[] args) {
        new Book().addDetails("Gödel, Escher, Bach: An Eternal Golden Braid", "Douglas R. Hofstadter", "Basic Books", 1979, 990);
        new Book().addDetails("Cryptonomicon", "Neal Stephenson", "Avon", 1999, 990);
        new Person().addDetails("Albert", "Einstein", 1879);
        new Person().addDetails("Werner", "Heisenberg", 1901);
    }
}