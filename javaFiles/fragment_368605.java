static int[] oddNumbers(int l, int r) {
    List<Integer> list1 = new ArrayList<>();
    if (l % 2 == 0) l++;
    for(; l <= r; l += 2) {
        list1.add(l);
    }
    return list1.stream().mapToInt(i->i).toArray(); // https://stackoverflow.com/a/23945015/2554605
}