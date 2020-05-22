List<List<Integer>> result = Arrays.asList(-1, -3, -5, -120, 0, 15, 24, 42, 13, -15, -24, -42, 1, 2, 3)
            .stream()
            .collect(Collector.of(
                    () -> {
                        List<List<Integer>> list = new ArrayList<>();
                        list.add(new ArrayList<>());
                        return list;
                    },
                    (list, x) -> {

                        if (x == 0) {
                            return;
                        }

                        if (list.size() == 0) {
                            list.get(0).add(x);
                        } else {
                            List<Integer> lastInner = list.get(list.size() - 1);
                            if (lastInner.size() > 0) {
                                int elem = lastInner.get(0);
                                if (elem >>> 31 == x >>> 31) {
                                    lastInner.add(x);
                                } else {
                                    List<Integer> oneMore = new ArrayList<>();
                                    oneMore.add(x);
                                    list.add(oneMore);
                                }
                            } else {
                                lastInner.add(x);
                            }

                        }

                    }, (left, right) -> {

                        throw new RuntimeException("Not for aprallel");
                    }));

    System.out.println(result);