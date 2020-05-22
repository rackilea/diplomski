List<SensorSample> result = samples.stream()
                .collect(groupingBy(sample -> SECONDS_IN_A_DAY*Math.floorDiv(sample.getTimestamp(), SECONDS_IN_A_DAY))
                .entrySet()
                .stream()
                .map(e -> {
                    SensorSample sensorSample = new SensorSample();
                    sensorSample.setTimestamp(e.getKey());
                    double average = e.getValue().stream()
                            .mapToDouble(SensorSample::getSample)
                            .average().orElse(0);
                    sensorSample.setSample(average);
                    sensorSample.setSensorType(e.getValue().get(0).getSensorType());
                    return sensorSample;
                }).collect(Collectors.toList());