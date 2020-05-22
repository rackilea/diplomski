mapper = new ObjectMapper();

Map<String,Object> data = mapper.readValue(inputstream, Map.class);

Container c = new Container();

for(Map.Entry<String, Object> me : data.entrySet()) {
    String key = me.getKey();
    Map info = (Map) me.getValue();

    ScoreKeeper sk = new ScoreKeeper();
    sk.setName(key);
    Integer q = info.get("score");
    sk.setScore(q);

    c.put(key, sk);
}