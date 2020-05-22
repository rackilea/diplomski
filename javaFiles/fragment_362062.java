public static void main(String[] args) {
    Scanner inputReader = new Scanner(System.in);
    System.out.println("How many times do you want to throw the dice:");
    int amount = inputReader.nextInt();

    Map<Integer, Integer> rolls = new HashMap<>();

    for (int i = 1; i < 7; i++) {
        rolls.put(i, 0);
    }

    for (int i = 0; i < amount; i++) {
        int value = (int) (Math.random() * 6 + 1);
        rolls.put(value, rolls.get(value) + 1);
    }

    for (Map.Entry<Integer, Integer> entry : rolls.entrySet()) {
        System.out.println(entry.getKey() + ": " + entry.getValue());
    }

}