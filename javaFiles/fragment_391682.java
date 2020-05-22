public static void main(String... args) {
    Map<String, String> path = new HashMap<>();
    path.put("start", "sb1");
    path.put("sb0", "sb3");
    path.put("sb1", "sb0");
    path.put("sb3", "end");

    printPath(path, "start");
}

void printPath(Map<String, String> path, String next) {
    if (next != null) {
        System.out.print(next);
        printPath(path, path.get(next));
    }
}