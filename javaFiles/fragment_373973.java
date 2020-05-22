public class Test 
{
    static
    {
        Runtime.getRuntime().loadLibrary("JNITests");
    }

    private long address;

    private native long construct0();
    private native void destruct0(long address);
    private native void setValue0(long address, int value);
    private native int getValue0(long address);

    public Test() {
        this.address = this.construct0();
    }

    @Override
    public void finalize() {
        this.destruct0(this.address);
        super.finalize();
    }

    public void setValue(int value) {
        this.setValue0(this.address, value);
    }

    public int getValue() {
        return this.getValue0(this.address);
    }

    public static void main(String[] args) 
    {
        Test test1 = new Test();
        test1.setValue(34);
        Test test2 = new Test();
        test2.setValue(23);
        System.out.println(test1.getValue());
    }
}