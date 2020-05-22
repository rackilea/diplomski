import java.util.ArrayList;

public class PrintThreeOfFive
{
  public static void main(String[] args)
  {
     char [][] one ={ {'a','b','c','d','e','f','g','h','3'},{'i','j','k','l','m','n','o','p','7'},{'q','r','s','t','u','v','w','x','2'}};

     int aSize=5;
     ArrayList<String> output = new ArrayList<String>();
     char [] firstThree=new char[3];
     for (int i=0; i< one.length;i++){
         int count = 0;
         for (int j=0; j < one[i].length; j++){

           //re-set count at the 5th character
           if (count == 4){ 
             count = 0;
             continue; //continue so that the fifth character is not added
           }

           //if in first three of five, add it to firstThree
           if (count < 3){
             firstThree[count]=one[i][j];
           }

           //increment count, and add to the list if at the third character
           count++;
           if (count == 3){
             output.add(new String(firstThree));
           }

         }
     }

    for (String s : output){
        System.out.println(s);
    }
  }
}