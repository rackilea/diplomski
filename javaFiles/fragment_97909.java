public static List<String> fill(List<List<String>> sources, int size) {
    return sources.stream()
        .sorted((a,b) -> b.size() - a.size())
        .reduce(new ArrayList<>(), (a, b) -> 
            {if (b.size() <= a.size() - size) a.addAll(b); return a;});
}