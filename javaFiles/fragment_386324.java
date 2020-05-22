abstract protected static class UnaryOp extends OneArgFunction {
    public LuaValue call(LuaValue arg) {
        return valueOf(call(arg.checkdouble()));
    }
    abstract protected double call(double d);
}

static final class abs extends UnaryOp {
    protected double call(double d) {
        return Math.abs(d);
    }
}