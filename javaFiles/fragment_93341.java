import java.util.*;

class NewTestC
{
 public static void main(String [] args)
 {
  Scanner inp = new Scanner(System.in);
  int ch=0;
  do
  {
  System.out.println("Press 1,add.");
  System.out.println("Press 2,addAll.");
  System.out.println("Enter your choice?");
  Integer choice = inp.nextInt();
  ArrayList <String>arr = new ArrayList<String>();
  arr.add("ABC");
  switch(choice)
  {

  case 1: 
 System.out.println("Enter the elements in an arraylist:");
 int i=0;
  while(i<2)
  {
          String obj=inp.next();
          arr.add(obj);
        i++;        
  }
  System.out.println("The elements are:" +arr);
  break;

  case 2:
  ArrayList <String>arr1=new ArrayList<String>();
  arr.add("7");
  arr1.add("AB");
  arr1.add("34");
  arr.addAll(arr1);
  System.out.println("The elements are:" +arr);
  break;
  } 
  System.out.printf("Press 0 to continue?");
  ch=inp.nextInt();
  }while(ch==0);
 }
}