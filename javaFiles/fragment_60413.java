import javax.swing.*;
import java.util.*;
import java.io.*;

class BookInfo
{
    String ISBN;
    String BookName;
    String AuthorName;
    String TotalBooks;

    // parameterized constructor
    // public (){}

    public BookInfo(String i, String b, String a)
    {
        ISBN = i;
        BookName = b;
        AuthorName = a;
    }

    ArrayList<BookInfo> books;

    // constructor
    public BookInfo()
    {

        books = new ArrayList<BookInfo>();
        loadbooks();
    }

    public void loadbooks()
    {
        String tokens[] = null;
        String no, name, author;
        try
        {
            FileReader fr = new FileReader("books.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            while(line != null)
            {
                tokens = line.split(",");
                no = tokens[0];
                name = tokens[1];
                author = tokens[2];
                BookInfo b = new BookInfo(no, name, author);
                books.add(b);
                line = br.readLine();
            }
            br.close();
            fr.close();
        }
        catch(IOException ioEx)
        {
            System.out.println(ioEx);
        }
    }

    public void savebooks()
    {
        try
        {
            BookInfo b;

            String line;
            FileWriter fw = new FileWriter("books.txt");
            PrintWriter pw = new PrintWriter(fw);
            for(int i = 0; i < books.size(); i++)
            {
                b = (BookInfo) books.get(i);
                line = b.ISBN + "," + b.BookName + "," + b.AuthorName;
                // writes line to file (books.txt)
                pw.println(line);
            }
            pw.flush();
            pw.close();
            fw.close();
        }
        catch(IOException ioEx)
        {
            System.out.println(ioEx);
        }
    }

    // add new book record to arraylist after taking input
    public void addbook()
    {
        String ISBN = JOptionPane.showInputDialog("Enter ISBN");
        String BookName = JOptionPane.showInputDialog("Enter Book Name");
        String AuthorName = JOptionPane.showInputDialog("Enter Author Name");
        // construct new book object
        BookInfo p = new BookInfo(ISBN, BookName, AuthorName);
        // add the above BookInfo object to arraylist
        books.add(p);
    }

    // search book record by name by iterating over arraylist
    public void searchBook(String n)
    {
        for(int i = 0; i < books.size(); i++)
        {
            BookInfo p = (BookInfo) books.get(i);
            if(n.equals(p.AuthorName))
            {
                p.print();
            }
        }
    }

    // delete book record by name by iterating over arraylist

    public void deleteBook(String n)
    {
        for(int i = 0; i < books.size(); i++)
        {
            BookInfo p = (BookInfo) books.get(i);
            if(n.equals(p.BookName))
            {
                // p.remove();
            }
        }
    }

    public void print()
    {
        // print your book here
    }

    class BookMgtSys
    {
    }

    public static void main(String args[])
    {
        BookInfo p = new BookInfo();
        String input, s;
        int ch;
        while(true)
        {
            input = JOptionPane.showInputDialog(
                    "Enter 1 to add " + "\n Enter 2 to             Search \n Enter 3 to Delete" + "\n Enter 4 to Exit");
            ch = Integer.parseInt(input);
            switch(ch)
            {
            case 1:
                p.addbook();
                break;
            case 2:
                s = JOptionPane.showInputDialog("Enter name to search ");
                p.searchBook(s);
                break;
            case 3:
                s = JOptionPane.showInputDialog("Enter name to delete ");
                p.deleteBook(s);
                break;
            }
        } // end while
    }// end main
} // end class