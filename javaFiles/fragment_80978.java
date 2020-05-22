static final String JSON_VAL="{\"A\":[{\"B\":[{\"C\":[{\"D1\":\"V1\",\"D2\":\"X1\",\"D3\":\"Y1\",\"D4\":\"Z1\"},{\"D1\":\"V2\",\"D2\":\"X2\",\"D3\":\"Y2\",\"D4\":\"Z2\"}]}]}]}";


final ObjectMapper mapper = new ObjectMapper();
final Wraper wraper = mapper.readValue(JSON_VAL, Wraper.class);

final Map<String,List<String>> map = new HashMap<>();

Arrays.stream(wraper.a).forEach(a -> {
    Arrays.stream(a.b).forEach(b -> {
        final List<String> d1 = new ArrayList<>();
        final List<String> d2 = new ArrayList<>();
        final List<String> d3 = new ArrayList<>();
        final List<String> d4 = new ArrayList<>();
        Arrays.stream(b.c).forEach(c -> {
            d1.add(c.d1);
            d2.add(c.d2);
            d3.add(c.d3);
            d4.add(c.d4);
        });
        map.put("A->B->C->D1", d1);
        map.put("A->B->C->D2", d2);
        map.put("A->B->C->D3", d3);
        map.put("A->B->C->D4", d4);
    });
});