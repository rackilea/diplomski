@Property
private ValueEncoder<MyItem> itemEncoder = new ValueEncoder<MyItem>() {
    @Override
    public String toClient(MyItem value) {
        return value.id != null ? value.id.toString() : "";
    }

    @Override
    public MyItem toValue(String clientValue) {
        if (clientValue != null && !clientValue.isEmpty()) {
            Long id = Long.parseLong(clientValue);
            return (MyItem) session.get(MyItem.class, id);
        }
        return new MyItem();
    }
};