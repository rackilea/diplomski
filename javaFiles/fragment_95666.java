import java.io.File;
  import java.text.DateFormat;
  import java.text.SimpleDateFormat;
  import java.util.Date;
  import java.util.Scanner;

  public class Administrator {

    public static String help_msg = "[ Main Menu ]\r\n\r\nAddBook\r\nRemoveBook\r\nBookInfo\r\nAddShelf\nRemoveShelf\r\nShelfInfo";
    private static final DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public static void main(String[] args){
      Date date = new Date();
      System.out.println(sdf.format(date));
      System.out.println("Welcome to my book library\r\n\r\n"+"ADMINISTRATOR\r\n\r\n"+help_msg+"\r\n");

      Scanner sc = new Scanner(System.in);
      String operate;

      while(!"Exit".equals(operate = sc.nextLine())){
        switch(operate) {
          case"AddBook":
            //chose shelf,add new book
          case"RemoveBook":
            //chose shelf,remove book
          case"BookInfo":
            //chose shelf,chose book,show book info
            break;
          case"AddShelf":
            try {
              System.out.println("Enter the name of the shelf:");
              String files;
              while(!"Exit".equals(files = sc.nextLine())){
                File dir = new File("D:\\admir\\MyBookLibrary\\"+files);
                dir.mkdirs();
                System.out.println(files+"Shelf added successfully!");
                System.out.println("Enter another name of the shelf:");
              }
              return;
            }catch(Exception e) {
              System.err.println("Unable to create new Shelf!");
            }
            break;
          case"RemoveShelf":
            //remove shelf
          case"ShelfInfo":
            //shelf info
          default:
            //if incorrect operation is entered,print message,back to choosing operations
        }
      }

    }
  }