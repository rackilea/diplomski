System.out.println("Name?");
Scanner keyboard = new Scanner(System.in);
String input = keyboard.nextLine();

for(int i=0;i<womenArray.length;i++) {
    if (womenArray[i].equals(input)) {
        System.out.println("Found! "+input);
    }
}