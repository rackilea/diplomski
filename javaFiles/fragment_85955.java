Item item = StreamEx.of(items)
                    .collect(MoreCollectors.pairing(
                       MoreCollectors.flatMapping(i -> i.set1.stream(), Collectors.toList()),
                       MoreCollectors.flatMapping(i -> i.set2.stream(), Collectors.toList()),
                       Item::new)
                    );