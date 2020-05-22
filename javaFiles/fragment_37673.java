public class SomeClassTest {
    private SomeClass mSomeClass;
    private Looper mLooper;

    @before
    public void setup(){
        mLooper = mock(Looper.class);
        Context ctx = mock(Context.class);
        when(ctx.getMainLooper()).thenReturn(mLooper);
        mSomeClass = new SomeClass(mContext);
    }
}