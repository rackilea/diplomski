Set<Integer> ysSet = new HashSet<>(ys);
List<Integer> xsPrime = new ArrayList<>();
for (Integer x : xs) {
    if (!ysSet.contains(x)) {
        xsPrime.add(x);
    }
}
return xsPrime;