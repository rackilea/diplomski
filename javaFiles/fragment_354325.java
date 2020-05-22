List<Integer> xs = new ArrayList<>();
// TODO: initialize xs with a bunch of values
List<Integer> ys = new ArrayList<>();
// TODO: initialize ys with a bunch of values
Set<Integer> ysSet = new HashSet<>(ys);
List<Integer> xsPrime = xs.stream()
    .filter(x -> !ysSet.contains(x))
    .collect(Collectors.toList());