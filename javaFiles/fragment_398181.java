public class MyListener extends DefaultExecuteListener {
    @Override
    public void renderEnd(ExecuteContext ctx) {
        if (ctx.data().containsKey("insert hint")) {
            ctx.sql(ctx.sql().replace(
                "insert into", 
                "insert " + ctx.data().get("insert hint") + " into"
            );
        }
    }
}