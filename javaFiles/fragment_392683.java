HashMap<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
    Collection items1 = basket.getItems();
    for (Iterator i = items1.iterator(); i.hasNext(); ) {
        Product p = (Product) i.next();

        ArrayList<Integer> list = map.get(p.title);

        if (list == null) {
            list = new ArrayList<Integer>();
            list.add(p.price);
            list.add(1);
        } else {
            list.set(1, list.get(1) + 1);
        }
        map.put(p.title, list);
    }