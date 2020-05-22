public class AlternativeEscapingStringBinding implements Binding<String, String> {
    ...

    @Override
    public void sql(BindingSQLContext<String> ctx) throws SQLException {
        if (ctx.paramType() == ParamType.INLINED) 
            if (ctx.value() == null)
                ctx.render().sql('null');
            else
                ctx.render()
                   .sql('\'')
                   .sql(ctx.value().replace("'", "\\'"))
                   .sql('\'');
        else
            ctx.render().sql('?');
    }
}