@Test(priority=20)
public void testInputFromConsoleToContinue_XX1(){
    System.out.println("Click any key and 'enter' key in Console to continue the tests..");
    Scanner scan = new Scanner(System.in);
    String line = scan.nextLine();
    System.out.println("continue the tests " + line);
}