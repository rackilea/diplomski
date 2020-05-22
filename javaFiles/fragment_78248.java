final Comparator<Order> sortByDateAsc = new Comparator<Order>() {
    private final Map<String, Date> map = new HashMap<>();

    @Override
    public int compare(Order o1, Order o2) {
        Date d1 = map.computeIfAbsent(o1.getOrderDate(), Date::new);
        Date d2 = map.computeIfAbsent(o2.getOrderDate(), Date::new);
        return d1.compareTo(d2);
    }
};

orders.sort(sortByDateAsc);