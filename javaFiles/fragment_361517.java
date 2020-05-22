import java.util.Random;
import jsr166y.ForkJoinPool;
import extra166y.Ops.LongGenerator;
import extra166y.Ops.LongOp;
import extra166y.ParallelLongArray;

public class ListParUnaryFunc {
    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        // create a parallel long array 
        // with random long values
        ParallelLongArray a =  ParallelLongArray.create(n-1, new ForkJoinPool());
        a.replaceWithGeneratedValue(generator);

        // use it: apply unaryLongFuncOp in parallel 
        //         to all values in array
        a.replaceWithMapping(unaryLongFuncOp);

        // examine it
        for(Long v : a.asList()){
            System.out.format("%d\n", v);
        }
    }

    static final Random rand = new Random(System.nanoTime());
    static LongGenerator generator = new LongGenerator() {
        @Override final
        public long op() { return rand.nextLong(); }
    };

    static LongOp unaryLongFuncOp = new LongOp() {
        @Override final public long op(long a) { return a * 2L; }
    };
}