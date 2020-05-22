public class TestClass1 {

static String  arr [] = new String[6];

public static void storeChoices(){

    Scanner sc = new Scanner(System.in);

    if(arr[0] == null){
      arr[0] = "Gucci";
      arr[1] = "Tesla";
      arr[2] = "Canada Goose";
      arr[3] = "Rolex";
      arr[4] = "Saks Fifth Avenue";
      arr[5] = "Nike";
    }

    for(int i = 0; i < arr.length; i++){
      System.out.println("  " + (i+1) + ")" + arr[i]);
    }
    System.out.println("Pick a number as your choice: ");

    int choice = sc.nextInt();

    sc.nextLine();

    for(int x = 0; x < arr.length; x++){
      arr[choice] = "Dr. Java has already visited this store";
    }


    }