HashMap<Integer,Integer> dataMap = new HashMap<>();

    for (int i=0; i <shoppingBagArrayList.size; i++){
        dataMap.put(shoppingBagArrayList.get(i).getProductId() , shoppingBagArrayList.get(i).getQty());
    }

    System.out.println("DataMap: "+dataMap);