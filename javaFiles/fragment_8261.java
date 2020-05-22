List<Foo> foosSort = foos.stream()
                     .sorted((o1, o2) -> (o1.sort - o2.sort))
                     .map(f -> {
                          List<Bar> bars = f.bars.stream()
                            .sorted((o1, o2) -> (o1.sort- o2.sort))
                            .collect(Collectors.toList());
                          f.bars = bars;
                          return f;
                     })
                     .collect(Collectors.toList());