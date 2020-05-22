Ordering<Item> o = new Ordering<Item>() {
    @Override
    public int compare(Item left, Item right) {
        return Ints.compare(left.price, right.price);
    }
};
return o.max(list);