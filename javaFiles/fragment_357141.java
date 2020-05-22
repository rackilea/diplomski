final Map<String, Integer> occurencesByFruit = new HashMap<>();
for (User user : users) {
    String[] fruits = user.getFruits();
    for (String fruit : fruits) {
        final Integer currentCount = occurencesByFruit.get(fruit);
        if (currentCount == null) {
            occurencesByFruit.put(fruit, 1);
        } else {
            occurencesByFruit.put(fruit, currentCount + 1);
        }
    }
}