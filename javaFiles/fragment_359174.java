Map<String, Map<String, Map<String,Commodity>>> root = new HashMap<String, Map<String,Map<String,Commodity>>>();
     Map<String, Commodity> leaf = new HashMap<String, Commodity>();
     leaf.put("fresh", new Commodity("name1", "type1"));
     leaf.put("notFresh", new Commodity("name2", "type2"));
     leaf.put("rotten", new Commodity("name3", "type3"));
     Map<String, Map<String,Commodity>> mid = new HashMap<String, Map<String,Commodity>>();
     mid.put("summer", leaf);
     mid.put("winter", leaf);
     root.put("vegetable", mid);
     root.put("fruit", mid);

    for (Entry<String, Map<String, Map<String, Commodity>>> middle: root.entrySet()) {
         Map<String, Map<String,Commodity>> midVal= middle.getValue();
         System.out.println("Type: "+ middle.getKey());
         for (Entry<String, Map<String, Commodity>> leaves : midVal.entrySet()) {
             Map<String,Commodity> leafVal = leaves.getValue();
             System.out.println("Season: " + leaves.getKey());
             for (Entry<String, Commodity> leafValNames : leafVal.entrySet()) {
                System.out.println("key: "+ leafValNames.getKey() + "value: " + leafValNames.getValue());
            }
        }
    }

}