for (String label : labels) {
    List<List<String>> paths = root.findPaths(label);
    for (List<String> path : paths) {
        printPath(path);
    }
}