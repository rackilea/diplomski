HashMap<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
    Collection items1 = basket.getItems();
    for (Iterator i = items1.iterator(); i.hasNext(); ) {
        Product p = (Product) i.next();

        if(map.containsKey(p.title)) {
            ArrayList<Integer> list = map.get(p.title);
            list.set(1, list.get(1) + 1);
            map.put(p.title, list);
        }
        else {
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(p.price);
            list.add(1);
            map.put(p.title,list);
        }
    }