import java.util.Scanner; 
    class Test{ 
    public static void main(String args[]){
    Scanner sc=new Scanner(System.in); 
     System.out.println("Pick option:\n 1-Option one\n 2-Option two :");
     int x= sc.nextInt();
    if (x==1)
    {
    System.out.println("You select option one");
    }
    else if(x==2){
            System.out.println("You select option two");
    }
    else{
    System.out.println("Please select option one or two by typing 1 or 2");
}                 

    } 
    }