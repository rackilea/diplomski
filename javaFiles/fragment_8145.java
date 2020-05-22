public static void create(int numComps) {
    c = new Computer[numComps];

    for (int i = 0; i < numComps; i++) {
        c[i] = new Computer();
        c[i].id = i + 1;
        c[i].bet = 50;

    }
}

public void bet() {
    cash -= bet;
}