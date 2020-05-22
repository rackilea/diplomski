Set<String> values = new HashSet<String>();
values.add("red");
values.add("blue");

List<Deal> output = 
        dl.stream()
          .map(d -> {
            d.getDealop().removeIf(o -> !values.contains(o.color));
            return d;
          })
          .collect(Collectors.toList());