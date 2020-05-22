BinaryOperator<A> joiner = (fst, snd) -> Optional.ofNullable(fst)
    .map(cur -> { cur.getList().addAll(snd.getList()); return cur; })
    .orElseGet(() -> new A(snd.getId(), snd.getName(), new ArrayList<>(snd.getList())));

Collection<A> result = list.stream()
    .collect(Collectors.groupingBy(A::getId, Collectors.reducing(null, joiner)))
    .values();