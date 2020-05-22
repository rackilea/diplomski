public class BootSample {

    private TestUtil testUtil;

    public BootSample(TestUtil testUtil) {
        this.testUtil = testUtil;
    }

    public int call(int m) {
        System.out.println("Entering into Call Method");
        int n = m*10;
        testUtil.add(m, n);
        System.out.println("End of Call Method Value n : " + n);
        return n;
    }
}