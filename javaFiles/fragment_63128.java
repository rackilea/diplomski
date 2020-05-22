import java.io.*;

interface Item {
    void read();
      void show();
}

class Book implements Item {

     String name,author,publication;
     public void read() {
     Console con  = System.console();

    System.out.println("Enter Name of the Book:");
    name = con.readLine();

    System.out.println("Enter Author Name:");
    author = con.readLine();

    System.out.println("Enter Publication of the book:");
    publication = con.readLine();  
}


     public void show() {
     System.out.println("List Of Issued Items");
      System.out.println("Name  :"+name);
          System.out.println("Author  :"+author);
         System.out.println("Publication :"+publication);
    } 
}

   class Dvd implements Item {

   String dname,director,category;

    public void read() {
    Console con  = System.console();

     System.out.println("Enter Name of the dvd ");
     dname = con.readLine();

     System.out.println("Enter Director Name");
     director = con.readLine();

     System.out.println("Enter Category of the dvd: ");
     category = con.readLine();
    }

     public void show() {
     System.out.println("List Of Issued Items");
       System.out.println("Name  :"+dname);
       System.out.println("Director  :"+director);
     System.out.println("Category :"+category);
    } 
  }