int maxPathLength = 3; // TODO calculate
Set<String> results = new TreeSet<String>();
process(paths, "", 0);

public void process(String[] paths, String prefix, int i, Set<String> results) {
    if (i >= maxPathLength) {
        System.out.println(prefix);
        results.add(prefix);
        return;
    }
    for (String s : paths) {
         if (i < s.length()) {
             process(paths, prefix + s.charAt(i), i + 1, results);
         }
    }
}