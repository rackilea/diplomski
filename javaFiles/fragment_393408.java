function.call(context, scope, null, new org.mozilla.javascript.Function() {
    @Override
    public Object call(Context cx, Scriptable scope, Scriptable thisObj, Object[] args) {
        System.out.println(args[0]);
    },

    // ...
});