private static List<String> lines = null;
static {
    try {
        lines = Files.readAllLines(new File("bundles.txt").toPath());
    } catch (IOException e) {
        e.printStackTrace();
    }
}
private Random rand = new Random();

public String getRandomItem() {
    return lines.get(rand.nextInt(lines.size()));
}