static final Function<Collection<Integer>, Double> averager = (values) -> {
        double sum = 0.0;
        for (Integer value : values) {
            sum += value.doubleValue();
        }
        return Double.valueOf(sum / values.size());
    };

static final Function<Collection<Integer>, Double> medianer = (values) -> {
        List<Integer> sorted = new ArrayList<>(values);
        sorted.sort(Comparator.comparingDouble(Number::doubleValue));
        // TODO treat odd/even number of elements separately
        return Double.valueOf(sorted.get(sorted.size() / 2).doubleValue());
    };