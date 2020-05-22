List<ShopOwnerMap> soms = ...; // the list you produced from the DB query.
List<ShopOwner> sos = ...; // your list of ShopOwners, each of which needs to be initialized with the shops they own, i.e. their initial lists of shops are empty.
// Note that the below could be reduced from O(N^2) to O(N) if you manage your ShopOwners using a Map (using an equals+hashCode scheme as suggested for Shop).
for (ShopOwnerMap som : soms) {
    for (ShopOwner so : sos) {
        // We assume that the 'owner' property (perhaps 'name' is more suitable?) is unique among ShopOwners.
        if (som.getOwner().equals(so.getOwner()) {
            // Found the corresponding shop owner; create shop instance and add to list of owned shops.
            so.addShop(new Shop(som.getShopId(), so));
        }
    }
}