public class MyBitSet extends BitSet {

    int realSize;


    public MyBitSet(int realsize) {
        // TODO Auto-generated constructor stub

        super(realsize);
        this.realSize=realsize;
    }

    public int realSize()
    {
        return this.realSize;
    }
}