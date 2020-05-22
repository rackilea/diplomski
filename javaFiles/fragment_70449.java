public static void main(String[] args) {

    List<Shop> shops = new LinkedList<Shop>();

    System.out.print("What is the ID of the shop that you want to delete?");
    Scanner scanner = new Scanner(System.in);
    int removedShopID = scanner.nextInt();

    boolean isFound = false;
    for (int i = 0; i < shops.size(); i++) {
        if (shops.get(i).getID() == removedShopID) {
            shops.remove(i);
            isFound = true;
            System.out.println("The shop has been successfully deleted.");
        }
    }
    if (!isFound) {
        System.out.println("Not found!");
    }
}