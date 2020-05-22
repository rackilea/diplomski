String header = null;
List<String> lines = getLines();
for (String line: lines) {
    String currentTime = line.substring(1, 14);
    if (!currentTime.equals(header)) {
        header = currentTime;
        System.out.format("%0$s:00:00\n", header);
    }
    System.out.println(line);
}