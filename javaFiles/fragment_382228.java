public enum Environment {PROD, STAGE}

public enum DataCenter {PHO, SLQ, LVK, NA /*Not applicable*/}

public class PoolSizes {

    public static final int SIZE_UNDEFINED = -1;

    private Map<Environment, Integer> environmentValues;

    public PoolSizes() {
        environmentValues = new HashMap<>();
    }

    public PoolSizes withStagePoolSize(int size) {
        environmentValues.put(Environment.STAGE, size);
        return this;
    }   

    public PoolSizes withProductionPoolSize(int size) {
        environmentValues.put(Environment.PROD, size);
        return this;
    }

    public int getPoolSize(Environment environment) {
        Integer size = environmentValues.get(environment);
        return size != null ? size : SIZE_UNDEFINED;            
    }        
}