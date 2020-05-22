Collection<A> result = list.stream()
    .collect(Collectors.groupingBy(A::getId, Reducer.reduce(A::new,
        (fst, snd) -> {
            fst.getList().addAll(snd.getList());
            fst.setId(snd.getId());
            fst.setName(snd.getName());
        }
    ))).values();