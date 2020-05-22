public class Test {

public static void main(String[] args) {
    // TODO Auto-generated method stub

    Scanner input = new Scanner(System.in);

    System.out.println("Input a string:"); 
       String s;
          s = input.nextLine();

     String[] strings = s.split(" ");
     int[] counts = new int[4];
     for(String str : strings)
          if(str.length() < counts.length) counts[str.length()] += 1;

     System.out.println(3 + " letter words: " + counts[3]); 

     input.close();

    // TODO Auto-generated method stub

   }//end main

}