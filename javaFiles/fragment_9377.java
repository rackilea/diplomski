public abstract class IBaseObject {
    protected String error;

    public IBaseObject(String param) {
        error = param;
    }

    public abstract String getError();
}

public class ObjectOne extends IBaseObject {        
    private String objectParam;        

    public ObjectOne(String error, String objectSpecificParam) {
        super(error);
        objectParam = objectSpecificParam;
    }

    @Override
    public String getError() {
        return error;
    }
}