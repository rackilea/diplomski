private static class MyItemHashMap extends HashMap {  
    public Item add(Item item) {  
        get(item).add(item);  
        return item;  
    }  

    public List get(Item key) {  
        List list = (List) get(createItemKey((Item) key));  
        return list == null ? createItemEntry((Item) key) : list;  
    }  

    private List createItemEntry(Item item) {  
        List list = new ArrayList();  
        put(createItemKey(item), list);  
        return list;  
    }  

    private Object createItemKey(Item item) {  
        return item.getSplitterProperty();  
    }  
    }  

    public static void main(String[] args) {  
    MyItemHashMap itemMapped = new MyItemHashMap();  
    List items = Arrays.asList(new Object[]{new Item("A"), new Item("B"),
    new  Item("C")});  
    for (Iterator iter = items.iterator(); iter.hasNext();) {  
    Item item = (Item) iter.next();  
    itemMapped.add(item);  
     }  
     }