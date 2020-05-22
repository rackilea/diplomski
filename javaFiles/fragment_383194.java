public static List<Path> removeUnwantedPaths(List<Path> listofPaths, List<String> ids) {
    return listofPaths.stream()
            .filter(p -> ids.contains(getIdFromPath(p)))
            .sorted(Comparator.comparing(p -> getIdFromPath(p)))
            .collect(Collectors.toList());
}

private static String getIdFromPath(Path p) {
    return p.getParent().getFileName().toString();
}