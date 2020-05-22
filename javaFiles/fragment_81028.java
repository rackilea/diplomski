m_objectMapper.addMixInAnnotations(YourMixIn.class, BasicDBObject.class);

public interface YourMixIn.class {
    @JsonAnySetter
    void put(String key, Object value);
}