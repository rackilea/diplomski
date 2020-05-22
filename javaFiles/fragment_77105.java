public class Test {
    private final int n;
    private final int m;
    private final int[] store;

    public Test(int n, int m) {
        // Primary constructor is unchanged
        this.n = n;
        this.m = m;
        store = new int[n];
        // ...
    }

    private static class ConstrParams {
        private int nParam;
        private int mParam;
        /* This class can also be used by more than one constructor
         or independently, to calculate the parameters and store
         them for other purposes. */
        private ConstrParams(Object data) {
            /* Calculate the parameters and/or do any other operations
             (preprocessing) that you would do in the specific constructor prior
             to calling another constructor. You may even add as many auxiliary
             methods as needed into this class and use them in this constructor. */
            nParam = 1;
            mParam = 2;
        }
    }

    /* Intermediate constructor, the main purpose of which is to extract
     parameters (if any) from a ConstrParams object and pass them to a primary
     or an inherited constructor. If ConstrParams produces no parameters but
     makes some pre-this() or -super() actions, this constructor makes
     insertion of such actions available. */
    private Test(ConstrParams params) {
        this(params.nParam, params.mParam);
        /* You can also call super(...) instead of this(...).
         When calling super(...), primary constructor may even not exist. */
//        super(params.nParam, params.mParam);
        /* As the reference to ConstrParams vanishes upon return to the
         calling constructor, you may want to make some actions connected
         with the params object (post-processing) or store the reference to it
         into this object. If so, here's the right place to do it. Otherwise,
         no further action is generally needed in this constructor. */
    }

    public Test(Object data) {
        // Specific constructor. Now compiles successfully.
        this(new ConstrParams(data));
        // ... further initialization
    }
}