import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.print("Enter a string:");
    String intialString = scan.nextLine();
    System.out.print("What is the character you would like to get the character before:");
    String character = "";
    while(true){
      character = scan.nextLine();
      if(character.length()==1)
        break;
      else
        System.out.print("Please enter only 1 character:");
    }
    System.out.println(getCharcterBeforeT(intialString, character.charAt(0)));
  }

  public static char getCharcterBeforeT(String str, char c){
    char returnChar = ' ';
    if (str.indexOf(c) == -1){
      System.out.println("Character '" + c + "' not found");
    } else if (str.indexOf(c) == 0){
      System.out.println("Character '" + c + "' is at start of string");
    } else {
      returnChar = str.charAt(str.indexOf(c) - 1);
    }
    return returnChar;
  }
}