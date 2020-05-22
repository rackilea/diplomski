public static void main(String[] arg) {
    // Get Number of Item
    System.out.print("Enter a Number of Items: ");
    Scanner sc = new Scanner(System.in);
    int itemNum = sc.nextInt();

    // Gathering Data
    int[] itemIdArr = new int[itemNum];
    int[] itemQuantityArr = new int[itemNum];
    for(int i = 0; i < itemNum; i++) {
        System.out.println("Item ID: ");
        itemIdArr[i] = sc.nextInt();
        System.out.println("Item Quantity: ");
        itemQuantityArr[i] = sc.nextInt();
    }
    sc.close();

    // Print Data
    System.out.println("Item ID / Item Quantity");
    for(int i = 0; i < itemNum; i++) {
        System.out.println(itemIdArr[i]+" / "+itemQuantityArr[i]);
    }
}