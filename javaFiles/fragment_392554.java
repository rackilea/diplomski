final List<Protocol> protocols = getProtocols();
final List<Sensor> sensors = getSensors();

// TODO : sort protocols here

// create a mapping between a referenceName and its index in protocols
final Map<String, Integer> referenceNameIndexesMap = IntStream.range(0, protocols.size()).mapToObj(i -> i)
            .collect(Collectors.toMap(i -> protocols.get(i).getReferenceName(), i -> i));

// sort sensors using this mapping
sensors.sort(Comparator.comparing(s -> referenceNameIndexesMap.get(s.getReferenceName())));

// sensors is now sorted in the same order of referenceName as protocols