public class Acount {
    private int clientId;
    private List<Purchase> purchases;
}

public class Purchase {
    private Date date;
    private Map<Item, Integer> itemsCount;
}

public class Item {
    private int itemId;
}