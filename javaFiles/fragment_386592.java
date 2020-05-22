@Test
public void bothColors() throws Exception {
    ArrayList<Toy> toyList = new ArrayList<>(Arrays.asList
        new Toy("blue", "car"),
        new Toy("red", "bike"));
    ToyBox box = new ToyBox(toyList);
    assertEquals(1, box.getBlues());
}

@Test
public void justBlues() throws Exception {
    ArrayList<Toy> toyList = new ArrayList<>(Arrays.asList
        new Toy("blue", "car"),
        new Toy("blue", "bike"));
    ToyBox box = new ToyBox(toyList);
    assertEquals(2, box.getBlues());
}

// etc...