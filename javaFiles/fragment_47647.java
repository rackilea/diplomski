class WorkaroundFor9813 extends DefaultExecuteListener {
    static final Pattern P = Pattern.compile("\\.\"(\\w+)\"\\(");
    @Override
    public void renderEnd(ExecuteContext ctx) {
        ctx.sql(P.matcher(ctx.sql()).replaceAll(".$1("));
    }
}