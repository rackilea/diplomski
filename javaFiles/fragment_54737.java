public abstract class IMSSQLStatement {

    protected IMSSQLHandler handler;

    public IMSSQLStatement() {
        handler = new IMSSQLHandler(this);
    }
}