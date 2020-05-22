private static final Function<Item, Integer> TO_PRICE =
  new Function<Item, Integer>() {
    @Override
    public Integer apply(Item item) {
      return item.price;
    }
  };