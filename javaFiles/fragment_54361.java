public interface CommentSchema {
    foo();
}

public abstract class CommentSchemaAbstractImpl implements CommentSchema {
    protected static final String DB_TABLE_NAME = "comment";
}

public class CommentSchemaRealImpl extends CommentSchemaAbstractImpl {
    @Override
    public void foo() {
        //do something...
        baz(DB_TABLE_NAME);
    }
    private void baz(String s) {
        //fancy code here...
    }
}