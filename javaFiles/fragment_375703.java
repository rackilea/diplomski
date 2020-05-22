try (BufferedWriter writer = new BufferedWriter(new FileWriter("randomNames.txt"))) {

    Random random = new Random();

    for (int i = 0; i < 20; i++) {
       int rowNum = random.nextInt(lines.size());
       writer.write(lines.get(rowNum));
       writer.newLine();
    }
}