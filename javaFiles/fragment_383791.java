public abstract class MessageField {
    public final int fieldId;
    public final String tag;

    protected MessageField(int fieldId, String tag) {
        this.fieldId = fieldId;
        this.tag = tag;
    }

    public int getFieldId() {
        return fieldId;
    }

    public String getTag() {
        return tag;
    }
}

public class TypeOne extends MessageField {
    public String fieldValue; //freely settable/gettable

    public TypeOne() {
        super(1, "->");
    }
}

// etc.