@Test
void test() throws NoSuchFieldException, IllegalAccessException {
    String[] filters = {"id=123", "name=foo"};

    List<Item> list = newArrayList(new Item(123, "abc"), new Item(2, "foo"), new Item(123, "foo"));

    Class<Item> itemClass = Item.class;

    for (String filter : filters) {
        String key = StringUtils.substringBefore(filter, "=");
        String value = StringUtils.substringAfter(filter, "=");

        Iterator<Item> iterator = list.iterator();
        while (iterator.hasNext()) {
            Item item = iterator.next();

            Field field = itemClass.getDeclaredField(key);
            field.setAccessible(true);
            Object itemValue = field.get(item);

            if (!value.equals(String.valueOf(itemValue))) {
                iterator.remove();
            }
        }
    }

    assertEquals(1, list.size());
}