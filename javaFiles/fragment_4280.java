PriorityQueue<String> pq = list.stream()
            .map(Person::getId)
            .distinct()
            .collect(Collectors.toCollection(() -> new PriorityQueue<>(
                    Comparator.comparing(x -> !"abc".equals(x))
                            .thenComparing(x -> !"bob".equals(x)))));