private static ArrayList<InventoryItem> inventory = new ArrayList<>();

     String newItemName = String.valueOf(xField);
     String newInventoryNumber = String.valueOf(yField);
     int newNumber = Integer.parseInt(newInventoryNumber);
     String newUnitPrice = String.valueOf(zField);
     double newPrice = Double.parseDouble(newUnitPrice);
     InventoryItem  item  =new InventoryItem(newItemName , newInventoryNumber , newNumber , newUnitPrice ) ;

     inventory.add(item);