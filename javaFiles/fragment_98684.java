List<Item> items = IntStream.range(0,transactions.size())
                            .mapToObj(i -> new Item(transactions.get(i),
                                                    users.get(i),
                                                    expirations.get(i),
                                                    confidential.get(i),
                                                    lockeds.get(i)))
                            .collect(Collectors.toList());