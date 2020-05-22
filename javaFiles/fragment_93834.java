class MyResult extends AsyncResult<Object> {
    Object id;
    public MyResult(Object id, Object res) {
        super(res);
        this.id = id;
    }
    public Object getId() {
        return id;
    }
}

@Async
public MyResult getAsyncInfo(Object id) {
    Object res = callService(id);
    return new MyResult(id, res);
}