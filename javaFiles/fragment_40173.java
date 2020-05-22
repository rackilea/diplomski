.collect(
        Collector.of(CopyOnWriteArrayList::new,
            List::add,
            (o, o2) -> { o.addAll(o2); return o; },
            Function.<List<String>>identity(),
            Collector.Characteristics.CONCURRENT,
            Collector.Characteristics.IDENTITY_FINISH
        )
    )