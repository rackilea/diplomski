Table<LocalDate, Integer, ImmutableList<String>> collect = list.stream()
        .collect(Tables.toTable(
                it -> it.left,
                it -> it.middle,
                it -> ImmutableList.of(it.right),
                (l1, l2) -> ImmutableList.<String>builder()
                        .addAll(l1).addAll(l2).build(), 
                HashBasedTable::create));