void printCombination(int[][] data, List<int> partial) {
    if (partial.size() == data.Length) {
        for (int i : partial) {
            if (i != -1) {
                System.out.writeln(" " + i);
            }
        }
        return;
    }
    if (data[partial.size()].length == 0) {
        partial.add(-1);
        printCombination(data, partial);
        partial.remove(partial.size()-1);
        return;
    }
    for (int i = 0 ; i != data[partial.size()].length; i++) {
        partial.add(data[partial.size()][i]);
        printCombination(data, partial);
        partial.remove(partial.size()-1);
    }
}