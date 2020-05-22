try (BufferedWriter writer = new BufferedWriter(new FileWriter("randomNames.txt"))) {
    Set<Integer> usedNumbers = new HashSet<Integer>(20);
    Random random = new Random();
    int addedCount = 0;

    while (addedCount < 20) {
        int rowNum = random.nextInt(lines.size());
        if (usedNumbers.add(rowNum)) {
            writer.write(lines.get(rowNum));
            writer.newLine();
            addedCount++;
        }
    }
}