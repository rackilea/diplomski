// the mockable interface
public interface ITableElementWrapper {
    public void insertRow(int index);
}

// the concrete implementation that you'll be using
public class TableElementWrapper implements ITableElementWrapper {
    TableElement wrapped;

    public TableElementWrapper(TableElement te) {
        this.wrapped = te;
    }

    public void insertRow(int index) {
        wrapped.insertRow(index);
    }
}

// the factory that your SUT should be injected with and be 
// using to wrap the table element with
public interface IGwtWrapperFactory {
    public ITableElementWrapper wrap(TableElement te);
}

public class GwtWrapperFactory implements IGwtWrapperFactory {
    public ITableElementWrapper wrap(TableElement te) {
        return new TableElementWrapper(te);
    }
}