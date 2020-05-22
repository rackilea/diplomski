static class max extends VarArgFunction {
    public Varargs invoke(Varargs args) {
    double m = args.checkdouble(1);
    for ( int i=2,n=args.narg(); i<=n; ++i )
        m = Math.max(m,args.checkdouble(i));
    return valueOf(m);
}