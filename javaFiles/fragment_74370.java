taskHandles.stream().map(this::mapTaskHandle)
                .flatMap(m -> m.entrySet().stream()).collect(
                        Collectors.toMap(Map.Entry::getKey, e -> e.getValue().entrySet().stream()
                                .collect(
                                        Collectors.toMap(Map.Entry::getKey,
                                                g -> new Genuineness(g.getValue().getTotal(), g.getValue().getTotalGenuine(), g.getValue().getTotalDevelopment()),
                                                (g1, g2) -> new Genuineness(g1.getTotal() + g2.getTotal(),
                                                        g1.getTotalGenuine() + g2.getTotalGenuine(),
                                                        g1.getTotalDevelopment() + g2.getTotalGenuine()
                                                )
                                        )
                                ),(l, r) -> {
                                  r.forEach((k, v) -> l.merge(k, v,
                                          (bi, bii) -> new Genuineness(bi.getTotal() + bii.getTotal(),
                                                  bi.getTotalGenuine() + bii.getTotalGenuine(),
                                                  bi.getTotalDevelopment() + bii.getTotalGenuine())));
                                  return l;
                                }

                        )
                );