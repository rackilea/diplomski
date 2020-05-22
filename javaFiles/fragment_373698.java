Table<LocalDate, Integer, List<String>> collect = list.stream()
        .collect(Tables.toTable(
                it -> it.left,
                it -> it.middle,
                it -> Lists.newArrayList(it.right),
                (l1, l2) -> {l1.addAll(l2); return l1;},
                HashBasedTable::create));