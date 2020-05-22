List<Item>[] basket = new List<Basket>[NUM_OF_ROWS];

for (int i = 0; i < NUM_OF_ROWS; i++) {
    basket[i] = new LinkedList<Item>();
}

basket[0].add(new Item(1, "APPLE", 12));
basket[1].add(new Item(2, "APPLE", 14));
// ...