public interface DataSourceOne {
    public Data getData();
}

public class DataSourceOneImpl implements DataSourceOne {
    public Data getData() {
        ...
        return data;
    }
}

public interface DataSourceTwo {
    public Data getData();
}

public class DataSourceTwoImpl implements DataSourceTwo {
    public Data getData() {
        ...
        return data;
    }
}