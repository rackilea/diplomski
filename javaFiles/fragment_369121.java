for (long l = 0; l < 1 << (input.size() - 1); l++) {
    List<Integer> combo = BitSet.valueOf(new long[]{l}).stream()
            .mapToObj(input::get).collect(Collectors.toList());
    if (combo.stream().mapToInt(n -> n).sum() == total) {
        System.out.println(combo);
    }
}