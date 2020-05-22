List<String> paths = Arrays.asList(
        "/src/main/java/tools/mockfile/generator/data/RecordPart.java",
        "/src/main/java/tools/mockfile/generator/Analyzer.java",
        "/src/main/java/tools/mockfile/test/Menu.java");

for (String path : paths) {
    Tree node = tree;
    for (String segment : path.split("/")) {
        node = node.computeIfAbsent(segment, s -> new Tree());
    }
}