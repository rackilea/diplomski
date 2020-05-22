Collection<Double> averages = IntStream.range(0, list.size() / 2)
        .map(i -> i * 2)
        .boxed()
        .collect(Collectors.groupingBy(list::get,
                Collectors.averagingDouble(i -> Double.parseDouble(list.get(i + 1)))))
        .values();
double maxAverage = Collections.max(averages);
System.out.println(maxAverage);