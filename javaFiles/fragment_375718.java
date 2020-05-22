Collector<Row, ?, List<Temp>> collector =
        Collector.of(ArrayList::new,
                     (list, element) -> list.add(DataMapper.apply(element)),
                     (left, right) -> {
                         left.addAll(right);
                         return left;
                     },
                     Characteristics.IDENTITY_FINISH
 );