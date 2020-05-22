Supplier<Map<String, Double>> supplier = TreeMap::new;
    BiConsumer<Map<String, Double>, SalesRecord> biConsumer = (map, sr) -> {
        map.merge("sum_qty", Double.valueOf(sr.getQty()), (qtySum, qty) -> qtySum + qty);
        map.merge("sum_gross", sr.getGross(), (grossSum, gross) -> grossSum + gross);
    };
    BinaryOperator<Map<String, Double>> binaryOperator = (l, r) -> {
        l.compute("sum_qty", (k, v) -> v + r.get("sum_qty"));
        l.compute("sum_gross", (k, v) -> v + r.get("sum_gross"));
        return l;
    };
    Collector<SalesRecord, Map<String, Double>, Map<String, Double>> collector = Collector.of(supplier, biConsumer, binaryOperator);