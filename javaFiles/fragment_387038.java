list.stream()
    .sorted(Comparator.comparing((String s) -> s.split("\\."),
        Comparator
            .comparing((String[] a) -> Integer.parseInt(a[0]))
            .thenComparingInt((a) -> a.length > 1 ? Integer.parseInt(a[1]) : 0))
    )
    .collect(Collectors.toList());