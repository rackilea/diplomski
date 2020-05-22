public abstract class PersistenceObject {

    private Context context;
    private volatile Db4oHelper helper;

    public PersistenceObject() { }

    public PersistenceObject(Context context) {
        this.context = context;
    }

    public Context getContext() {
        this.getContext();
    }

    public final void setContext(Context context) {
        if (this.context != context) {
            if (this.context == null) {
                onContextSet(context);
            } else if(context == null) {
                onContextUnset(context);
            } else {
                // Should you allow the context to change? 
                // Maybe the object is dirty, if so what to do?
                onContextChanged(context, this.context);
            }
            this.context = context;
        }
    }

    // we can call initialize on objects that extends this class
    // this initializes the context and also call the overloaded
    // initialize method to allow the classes to provided what
    // need to be done after we setup the context
    public final void initialize(Context context) {
        this.setContext(context);
        this.initialize();
    }

    private void onContextSet(Context context) {
        // ...
    }

    private void onContextUnset(Context context) {
        // lets clean the helper when we set the context to null
        this.helper == null;
    }

    private void onContextChanged(Context newContext, Context oldContext) {
        // Lets assume we can change the context
        // Since we change the context lets set the helper to null, 
        // so in the next call we get a new helper with the right context
        this.helper == null;
    }

    protected final Db4oHelper getDb4oHelper() {
        Db4oHelper helper = this.helper;
        if (helper == null) {
            synchronized(this) {
                helper = this.helper;
                if (helper == null) {
                    helper = this.helper = new Db4oHelper(context);
                    helper.db();
                }
            }
        }
        return helper;
    }

    public void initialize() {
    }
}