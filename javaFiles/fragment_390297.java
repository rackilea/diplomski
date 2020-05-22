ImmutableTable.copyOf(itemList.parallelStream()
                    .map(item ->
                            ProcessorInstanceProvider.get()
                            .build(item))
                    .collect(() -> HashBasedTable.create(),
                            (a, b) -> a.putAll(b),
                            (a, b) -> a.putAll(b))
                    );