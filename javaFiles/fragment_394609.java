public class FinalArrayTest {
    Data data;

    public static class Data {
        final int[] arr;

        public Data() {
            arr = new int[]{1, 0};
            arr[1] = 2; // (w)
        } // (F)
    }

    @Actor
    public void actor1() {
        data = new Data(); // (a)
    }

    @Actor
    public void actor2(IntResult1 r) {
        // ignore null pointers for brevity
        Data d = this.data; 
        int[] arr = d.arr; // (r1)
        r.r1 = arr[1]; // (r2) 
    }
}