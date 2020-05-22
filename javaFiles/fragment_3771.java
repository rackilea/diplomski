TreeMap<Long, List<Integer>> tm = m.entrySet().stream()
            .collect(Collectors.toMap(
                  Entry::getValue, 
                  x -> {
                      List<Integer> list = new ArrayList<>();
                      list.add(x.getKey());
                      return list;
                  }, 
                  (left, right) -> {
                     left.addAll(right);
                     return left;
                  }, 
                  TreeMap::new));