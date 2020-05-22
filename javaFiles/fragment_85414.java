Scanner S = new Scanner(System.in);
    boolean found = false;
    String[] auctions = {"Car - Honda Civic VTI 1.8 Petrol", "Sony Bluetooth Speakers", "auctionObject" };
    java.util.List<String> list1 = java.util.Arrays.asList(auctions);

    System.out.println("---Browse Auction---");
    System.out.println("Search::");
    String searchWord = S.next().toLowerCase();

    //Searching all auctions for 'searchWord' key.
    for (int i = 0; i < list1.size(); i++){
        String currentAuction = list1.get(i).toLowerCase();
        if (currentAuction.contains(searchWord)) {
            System.out.println("Auction Found : " + list1.get(i));
            found = true;
        }
    }

    //There is no match for 'searchWord' key.
    if (!found)
        System.out.println("No Match Found :");