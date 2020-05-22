public class ListToMapCollector implements Collector<String, Map<String, 
     List<String>>, Map<String, List<String>>>
    {
    private String mapKey;

    public TestCollector(String string)
    {
        this.mapKey = string;
    }

    @Override
    public Supplier<Map<String, List<String>>> supplier() {
        // provide HashMap for result
        return HashMap::new;
    }

    @Override
    public BiConsumer<Map<String, List<String>>, String> accumulator() {
        return (map, stringValue) -> {
            if (!map.containsKey(mapKey))
            {
                map.put(mapKey, new ArrayList<>());
            }
            map.get(mapKey).add(stringValue);
        };
    }

    @Override
    public BinaryOperator<Map<String, List<String>>> combiner() {
        // Needed for parrallel stream, excluded for brevity.
        return null;
    }

    @Override
    public Function<Map<String, List<String>>, Map<String, List<String>>> finisher() {
        return Function.identity();
    }

    @Override
    public Set<java.util.stream.Collector.Characteristics> characteristics() {
        return Collections.singleton(Characteristics.IDENTITY_FINISH);
    }
    }