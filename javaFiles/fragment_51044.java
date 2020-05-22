public static void test1(String[] args) {
    final Map<Integer, Integer> map;

    try {
        map = readFromFile();
    }
    catch (IOException e) {
        // handle the exceptional situation
        return; // or throw another exception, but leave the method
    }

    final List<Integer> list = new ArrayList<>();
    list.stream().map(x -> map.get(x)).collect(Collectors.toList());
}