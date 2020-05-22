public OrderTest(Byte id, Byte coffee, Byte cafelatte, Byte smoothie, Byte iceCoffee) {
    order = new Order(new byte[] {id, coffee, cafelatte, smoothie, iceCoffee});
}

@Parameters
public static Collection order() {
    return Arrays.asList(new Byte[][] {
        {1, 1, 0, 0, 0},
        {2, 1, 1, 0, 0},
        {3, 1, 1, 1, 1},
        {14, 80, 127, 127, 127}
    });
}