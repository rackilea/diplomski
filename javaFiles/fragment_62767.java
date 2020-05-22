String[] msg = { "Weight of Item 1", "Weight of Item 2", "Weight of Item 3",
        "Total Weight Kilograms" };
int[] items = { ITEM_1, ITEM_2, ITEM_3, totalWeightKilograms };
for (int i = 0; i < msg.length; i++) {
    System.out.printf("%22s: %10d%n", msg[i], items[i]);
}