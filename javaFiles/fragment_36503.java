public static void showVideoList()
{
    System.out.println();
    System.out.println(
            "********************************************************************");
    System.out.println("List of the Videos are: ");
    System.out.println(
            "********************************************************************");

    // **USE PRINTF TO GIVE BETTER FORMATTING
    System.out.printf("%10s     %53s%n","Serial No","Video Details");


    for (int i = 0; i < VTable.size(); i++) {
        // **USE SIMILAR FORMATTING OUTPUT
        System.out.printf("%10d     %53s%n", VTable.get(i).getSerial(), VTable.get(i));
    }
    System.out.println();
}