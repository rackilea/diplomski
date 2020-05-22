public interface MyInt<C extends WhereClause> {

    public Map<String, C> createClauses(Parameters<Object> params);
}

private static class MyWhereClause extends WhereClause {

    public MyWhereClause() {
    }
}

public class MyImpl implements MyInt<MyWhereClause> {

    @Override
    public Map<String, MyWhereClause> createClauses(Parameters<Object> p) {
        return null;
    }
}