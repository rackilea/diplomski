package mavens.dais.test;

public class ClassesTest {

   private int Numbers;

   public ClassesTest() {}

   ClassesTest(String namez) {
      Numbers = Integer.parseInt(namez);
   }


   public int getNumbers() {
      return Numbers;
   }

    public void setNumbers(int numberz) {
        if(numberz > 10){
            System.out.print("It is worked.");
        }else{
            System.out.print("It is not worked.");
        }
    }


}



package mavens.dais.test;

import java.util.Scanner;

public class OneTwoThre {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter a number: ");
        new ClassesTest().setNumbers(Integer.parseInt(keyboard.nextLine()));
    }   

}