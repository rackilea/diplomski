public static void main(String[] args) throws IOException{

    ArmyDataList army = new ArmyDataList();
    Scanner fileScan = new Scanner(new File("regiments.txt"));
    System.out.println("Report Summary:\n");
    while (fileScan.hasNext()) {
        String line = fileScan.nextLine();
        System.out.println(line);
        Scanner in = new Scanner(line);
        int regNumber = in.nextInt();
        String name = in.next();
        int men = 0 ; //men is set to 0 only because I havent add the men yet
        Regiment adder = new Regiment(regNumber, name, men );
        army.AddToList(adder);
    }
    System.out.println(army.toString()); //print out the initial # of men
    for(int i = 0; i < 20; i++)
        army.addMen();
    System.out.println(army.toString()); //print the final # of men
}