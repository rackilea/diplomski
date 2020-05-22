public void  adjustItemAmount (String itemName, int x,String listID){
            int current_amount = shoppingLists.get(listID).get(itemName);
            HashMap <String,Integer> items = shoppingLists.get(listID);
            items.put(itemName,items.get(itemName)+x);
            shoppingLists.put(listID,items);    
        }