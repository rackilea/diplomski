public static List<String> fill(List<List<String>> sources, int size) {
    List<String> list = new ArrayList<>();
    for (List<String> source : sources) 
        if (source.size() <= size - list.size()) 
            list.addAll(source);
    return list;
}