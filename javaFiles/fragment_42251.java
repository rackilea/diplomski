public static List<List<String>> cartesianRecursive(List<List<String>> list) {
    List<List<String>> result = new ArrayList<List<String>>();
    int numSets = list.size();
    String[] tmpResult = new String[numSets];
    cartesianRecursive(list, 0, tmpResult, result);

    return result;
}

public static void cartesianRecursive(List<List<String>> list, int n, String[] tmpResult, List<List<String>> result) {
    if (n == list.size()) {
        result.add(new ArrayList<String>(Arrays.asList(tmpResult)));
        return;
    }

    for (String i : list.get(n)) {
        tmpResult[n] = i;
        cartesianRecursive(list, n + 1, tmpResult, result);
    }
}