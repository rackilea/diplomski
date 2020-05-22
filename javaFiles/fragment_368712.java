package phoneBook;

import java.io.*;
import java.util.Properties;

class meths {
 BufferedReader br;
 FileInputStream fin;
 String name, number;
 Properties pr;
 File file;
 String path = "D:/PhoneBook.txt";

 public meths() {
    file = new File(path);
    pr = new Properties();
    br = new BufferedReader(new InputStreamReader(System.in));

    //If file doesn't exist, create it and load it
    if (!(file.exists() && file.canRead())){
        try {
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("File can't be created");
        }
    }
        try {
            fin = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            System.out.println("File can't be read");
        }

    // If file is not empty, load properties
    if (fin != null) {
        try {
            pr.load(fin);
            fin.close();

        } catch (IOException e) {
            System.out.println("Properties not loaded");
        }
     }
  }

 void find() throws IOException {
    System.out.println("\n>Enter name to find number:");
    name = br.readLine();
    System.out.println("Number is: " + pr.getProperty(name));
 }

 void enter() throws IOException {
    System.out.println("\n>Enter the name :");
    name = br.readLine();
    System.out.println("\n>Enter the number :");
    number = br.readLine();

    FileOutputStream fout = new FileOutputStream(file);

    pr.put(name, number);
    pr.store(fout, "Phone Boook");
 }

 void choice() throws IOException {
    System.out.println("\n>Enter your choice :");
 }

 public boolean isInteger(String chaine) {
    try {
        Integer.parseInt(chaine);
    } catch (NumberFormatException e) {
        return false;
    }
    return true;
  }

void operation() throws IOException {
    int opt = 0;

    System.out.println("1 for stop operation\n2 for enter new entry\n3 for searching number\n");

    while (opt != 1) {
        choice();
        String value = br.readLine();
        if (isInteger(value)) {
            opt = Integer.parseInt(value);
            switch (opt) {
            case 2:
                enter();
                break;
            case 3:
                find();
                break;
            }
         }
      }
   }
 }

 public class PhoneBook {

  public static void main(String args[]) throws Exception {
    meths ph = new meths();
    ph.operation();
  }
}