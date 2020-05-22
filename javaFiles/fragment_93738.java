// get the ID
int auctionId = scanner.nextInt();
itemInfo selectedInfo;

// find that item
 for(itemInfo info : itemSet){
    if(info.auctionId = auctionId){
        selectedInfo = info;
        break;
    }
}

if(selectedInfo == null){
    // the ID was not valid!
   // do something to handle this case.
} else {
    System.out.println(selectedInfo.auctionID);
    System.out.println(selectedInfo.auctionPrice);
    System.out.println(selectedInfo.buyoutPrice);
}