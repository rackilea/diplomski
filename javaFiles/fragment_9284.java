// do the whole collecting thing like before
Map<String, Integer> map = sampleList.stream()
    .collect(Collectors.groupingBy(sample -> convertType(sample.getTypeId()),
            Collectors.collectingAndThen(
                Collectors.groupingBy(Sample::getSampleType,
                    Collectors.summingInt(Sample::getSampleQuantity)),
                        map -> map.getOrDefault(SampleType.ADD, 0)
                                - map.getOrDefault(SampleType.SUBTRACT, 0))));

// return the "beautified" result
return toSummaryResultList(map);