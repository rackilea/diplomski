Map<BigInteger, BigInteger> mapfinal =
            IntStream.iterate(0, i -> i < list.size(), i -> i += 2).mapToObj(
                  i -> new BigInteger[] { list.get(i), list.get(i + 1)
                  }).collect(Collectors.groupingBy(i -> i[0],
                        Collectors.reducing(BigInteger.ZERO,
                              a -> a[1],
                              (a, b) -> a.add(b))));