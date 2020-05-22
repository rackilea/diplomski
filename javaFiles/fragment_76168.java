//First get your UserType from cluster object
UserType oderItemType = cluster.getMetadata()
        .getKeyspace(session.getLoggedKeyspace())
        .getUserType("order_items");

//Now you can create a UDTValue from your UserType order_items and set value 
UDTValue oderItem = oderItemType.newValue()
        .setInt("qty", 2)
        .setString("name", "mocha")
        .setString("milk_type", "whole")
        .setString("size", "small")
        .setDecimal("price", new BigDecimal(2.5));

// Though you define UDT of List Let's create a list and put the value
List<UDTValue> orders = new ArrayList<>();
orders.add(oderItem);