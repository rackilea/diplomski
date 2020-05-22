public class GenValue {
    private final byte dataType;
    private final byte[] value;

    public GenVal(byte dataType, byte[] value) {
        this.dataType = dataType;
        this.value = value;
    }

    public byte getDataType() {
        return dataType;
    }

    public byte[] getValue() {
        return value;
    }
}

public class DataPacket {
    private final String startTag;
    private final String code;
    private final String name;
    private final String info;
    private final GenValue type;
    private final GenValue count1;
    private final GenValue count2;
    private final String endTag;

    public DataPacket(String startTag, other args here...) {
        this.startTag = startTag;
        // Set the other properties from constructor args...
    }

    public String getStartTag() {
        return startTag;
    }

    // Add getters for the other properties...
}