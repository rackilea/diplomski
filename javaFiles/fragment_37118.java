Maps.asMap(
     ContiguousSet.create(Range.closedOpen(0, names.size()), DiscreteDomain.integers()),
          new Function<Integer, String>() {
              @Override
              public String apply(Integer input) {
                  return names.get(input);
              }
          });