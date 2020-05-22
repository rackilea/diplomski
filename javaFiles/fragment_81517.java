HashMap<String, Set<String>> nodes = new HashMap<>();
    File file = new File("E:/test.txt");

    try (Stream<String> stream = Files.lines(file.toPath())) {
        stream.forEach((line) -> {
            String parts[] = line.split(";");
            nodes.putIfAbsent(parts[0], new HashSet<>());
            nodes.putIfAbsent(parts[1], new HashSet<>());
            nodes.get(parts[1]).add(parts[0]);
        });
    } catch (Exception e) {
        e.printStackTrace();
    }