public Inventory initialiseInventory(){
       Inventory inventoryObj=new Inventory();
       HashMap<Integer,Item> itemMap=new HashMap<Integer,Item>;


       Sword swordObj=new Sword();
       Rings ringsObj=new Rings();


       swordObj.setInitialStock(100);//100 swords in place
       ringsObj.setInitialStcok(200);//200 rings in place


       itemMap.put(ID.SWORDS,swordObj);
       itemMap.put(ID.RINGS,ringsObj);

       inventoryObj.setItemMap(itemMap);

       return inventoryObj;
    }


    public viewInventory(Inventory inventory){

    for(Entry<Integer,Item> itemEntry:inventory.itemMap.entrySet()){

           Item itemObj=itemEntry.getValue();
           System.out.println(itemObj.getItemName());
           System.out.println("---------------------------------");
           System.out.println(itemObj.getInitialStock());
           System.out.println(itemObj.getCurrentStock());

        }
    }

   Now, you can to represent removal of an item, you can reduce the count for that particular item. This is a skeleton, you can improve on it.