import java.io.*;
class Library {
    public static void main(String args[]) {

    Console con  = System.console();
        Item arr[] = new Item[2];
        Item a;

        for(int i=0;i<arr.length;i++) 
    {
        System.out.println("Enter Your Choice : < b / d >");
            String ch = con.readLine();


                   switch(ch) 
        {

            case "b": 
                arr[i] = new Book();
                arr[i].read();
            break;

            case "d": 
                arr[i] = new Dvd();
            arr[i].read();
            break;

            default:
            System.out.println(" You Enetred The Wrong Choice !!!");    
            }
            }

             for(int i=0;i<arr.length;i++)
                arr[i].show();                          


      }
}