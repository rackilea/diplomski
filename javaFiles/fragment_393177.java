// Re-using the serializer as per "Thread Safety and Reuse"
// section of http://flexjson.sourceforge.net/
public static final flexjson.JSONSerializer jsonSerializer;
static {
    jsonSerializer = new flexjson.JSONSerializer().exclude("*.class");
}

public String toJSON() {
    return jsonSerializer.deepSerialize(this);
}