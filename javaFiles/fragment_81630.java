List<String> lines = Files.readAllLines(Paths.get("/path/to/arrivals.csv"));

Map<Integer, Double> averages = lines.stream()
                                     .map(s -> s.split("   "))
                                     .collect(
                                        Collectors.groupingBy(
                                           r -> Integer.parseInt(r[0]),
                                           Collectors.averagingDouble(v -> Double.parseDouble(v[1]))
                                        )
                                     );