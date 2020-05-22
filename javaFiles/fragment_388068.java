access.addItem(itemId, new DataCallback() {
    @Override
    public void changed(Item item, ItemState state) {
        System.out.println("Data change " + state.getObjectAsUnsigned().getValue() + " : " + state);
    }
});