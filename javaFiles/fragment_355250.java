List<SensorSample> result = samples.stream()
                .collect(groupingBy(sample -> SECONDS_IN_A_DAY*Math.floorDiv(sample.getTimestamp(), SECONDS_IN_A_DAY))
                .entrySet()
                .stream()
                .map(Main::apply)
                .collect(Collectors.toList());