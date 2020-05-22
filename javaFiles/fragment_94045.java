final Map<String, List<Double>> map = new Gson().fromJson("{\"[1,2,3,5]\"=[4,5,6]}", Map.class);
    final Map<List<Long>, List<Long>> result = Maps.newHashMap();
    for (final Map.Entry<String, List<Double>> entry : map.entrySet()) {
        final List<Long> value = Lists.newArrayList();
        for (final Double number : entry.getValue()) {
            value.add(number.longValue());
        }
        final List<Double> rawKey = new Gson().fromJson(entry.getKey(), List.class);
        final List<Long> key = Lists.newArrayList();
        for (final Double number : rawKey) {
            key.add(number.longValue());
        }
        result.put(key, value);
    }
    System.out.println(result);