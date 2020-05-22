QuoteProductDTO prod = lstQuoteProductDTO.stream()
                .collect(Collectors.teeing(
                        Collectors.maxBy(Comparator
                                .comparing(p -> p.value1)),
                        Collectors.summingDouble(
                                p -> p.value2),
                        (a, b) -> new QuoteProductDTO(
                                a.orElse(emptyQuote).name,
                                a.orElse(emptyQuote).value1,
                                b.doubleValue())));

        System.out.println(prod);