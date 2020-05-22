File file = new File("D:\\hl_sv\\L09MF.txt");
try (PrintWriter writer = new PrintWriter("D:\\hl_sv\\L09MF2.txt");
        Scanner scanner = new Scanner(file)) {
    while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        writer.println(line.replace('?', '-'));
    }
} catch (Exception e) {
    e.printStackTrace();
}