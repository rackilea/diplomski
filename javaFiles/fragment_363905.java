static List<List<String>> generateCombinationOf(List<String> list) {
    List<List<String>> result = new ArrayList<>();
    for (int i = 0, max = 1 << list.size(); i < max; ++i) {
        List<String> comb = new ArrayList<>();
        for (int j = 0, k = i; k > 0; ++j, k >>= 1)
            if ((k & 1) == 1)
                comb.add(list.get(j));
        result.add(comb);
    }
    return result;
}