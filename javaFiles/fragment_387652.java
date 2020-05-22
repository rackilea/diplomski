public static void main(String[] args) {
    ArrayList<TrackingSystem> tracker = new ArrayList<>();
    Main myApp = new Main();
    myApp.menu();
    System.out.print("Select option >> ");
    int option = in.nextInt();

    switch (option){
        case 1:
            myApp.CreateIssue(tracker);
            break;
        case 2:
            break;
        case 3:
            break;
        case 4:
            break;
        case 5:
            System.exit(0);
            break;
        default:
            System.out.println("Invalid choice...!");
            break;

    }
}