public class MetricValueDtoDeserializer<T> extends StdDeserializer<MetricValueDto<T>> {

    private static final long serialVersionUID = 1L;

    public MetricValueDtoDeserializer() {
        this(null);
    }

    public MetricValueDtoDeserializer(Class<?> vc) {
        super(vc);
    }

    private ObjectMapper mapper;

    @Override
    public MetricValueDto<T> deserialize(JsonParser jsonParser, DeserializationContext context)
            throws IOException, JsonProcessingException {
        String metricType = jsonParser.getCurrentName();
        mapper = (ObjectMapper) jsonParser.getCodec();
        ObjectNode objectNode = (ObjectNode) mapper.readTree(jsonParser);
        Iterator<Entry<String, JsonNode>> elementsIterator = objectNode.fields();
        Number number = null;
        while (elementsIterator.hasNext()) {
            Entry<String, JsonNode> element = elementsIterator.next();
            String key = element.getKey();
            if (key.equals("value")) {
                number = parseValue(element, metricType);
            }
            if (key.equals("trend")) {
                MetricTrend metricTrend = parseTrend(element);
                return (produceMetricValueDto(number, metricTrend));
            }
        }
        throw new IOException();
    }

    @SuppressWarnings("unchecked")
    private MetricValueDto<T> produceMetricValueDto(Number number, MetricTrend metricTrend) throws IOException {
        if (number instanceof Integer) {
            return (MetricValueDto<T>) new IntMetricValueDto((Integer) number, metricTrend);
        } else if (number instanceof Float) {
            return (MetricValueDto<T>) new FloatMetricValueDto((Float) number, metricTrend);
        }
        throw new IOException();
    }

    private MetricTrend parseTrend(Entry<String, JsonNode> element)
            throws JsonProcessingException {
        String trend = mapper.treeToValue(element.getValue(), String.class);
        if (trend == null) {
            return null;
        } else {
            return MetricTrend.valueOf(trend);
        }
    }

    private Number parseValue(Entry<String, JsonNode> element, String metricType)
            throws IOException {
        if (metricType.equals(MetricType.CANOPY_COVERAGE.toValue())
                || metricType.equals(MetricType.PLANT_SIZE.toValue())) {
            return mapper.treeToValue(element.getValue(), Float.class);
        } else if (metricType.equals(MetricType.INSECT_COUNT.toValue())
                || metricType.equals(MetricType.PLANT_COUNT.toValue())) {
            return mapper.treeToValue(element.getValue(), Integer.class);
        }
        throw new IOException();
    }
}