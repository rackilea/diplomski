import java.util.concurrent.*;

public class TreeCalculation
{
    // tree level to go parallel
    int levelParallel;
    // total number of generated tasks
    long totalTasks;
    // current number of open tasks
    long nTasks;
    // total height of tree
    int height;
    // Executors
    ExecutorService exec;
    CompletionService<Long> cs;

    TreeCalculation(int height, int levelParallel)
    {
        this.height = height;
        this.levelParallel = levelParallel;
    }

    void incrementTasks()
    {
        ++nTasks;
        ++totalTasks;
    }

    void decrementTasks()
    {
        --nTasks;
    }

    long getNTasks()
    {
        return nTasks;
    }

    // Where the ExecutorService should be initialized
    // with a specific threadCount
    void preProcess(int threadCount)
    {
        exec = Executors.newFixedThreadPool(threadCount);
        cs = new ExecutorCompletionService<Long>(exec);
        nTasks = 0;
        totalTasks = 0;
    }

    // Where the CompletionService should collect the results;
    long postProcess()
    {
        exec.shutdown();
        long result = 0;
        for (int i = 0; i < (long) Math.pow(2, levelParallel); i++)
        {
            try
            {
                result += cs.take().get();
                decrementTasks();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        return result;
    }

    public static void main(String[] args)
    {

        int height = 22;
        int levelParallel = 3;
        int threadCount = 4;
        if (args.length != 3)
        {
            System.out.println(
                "usage: java Tree treeHeight levelParallel nthreads\n");
            System.out.println("Using default values for test");
        }
        else
        {
            height = Integer.parseInt(args[0]);
            levelParallel = Integer.parseInt(args[1]);
            threadCount = Integer.parseInt(args[2]);

        }

        TreeCalculation tc = new TreeCalculation(height, levelParallel);

        // generate balanced binary tree
        Tree t = Tree.genTree(height, height);

        // traverse sequential
        long t0 = System.nanoTime();
        long p1 = t.processTree();
        double t1 = (System.nanoTime() - t0) * 1e-9;

        t0 = System.nanoTime();
        tc.preProcess(threadCount);
        long p2 = t.processTreeParallel(tc);
        p2 += tc.postProcess();
        double t2 = (System.nanoTime() - t0) * 1e-9;

        long ref = (Tree.counter * (Tree.counter + 1)) / 2;
        if (p1 != ref)
            System.out.printf("ERROR: sum %d != reference %d\n", p1, ref);
        if (p1 != p2)
            System.out.printf("ERROR: sum %d != parallel %d\n", p1, p2);
        if (tc.totalTasks != (1 << levelParallel))
        {
            System.out.printf("ERROR: ntasks %d != %d\n", 1 << levelParallel,
                tc.totalTasks);
        }

        // print timing
        System.out.printf("tree height: %2d\n" 
            + "sequential: %.6f\n"
            + "parallel with %3d threads and %6d tasks: %.6f\n"
            + "speedup: %.3f count: %d\n",
            height, t1, threadCount, tc.totalTasks, t2, t1 / t2, ref);
    }
}

// ============================================================================

class Tree
{

    static long counter; // counter for consecutive node numbering

    int level; // node level
    long value; // node value
    Tree left; // left child
    Tree right; // right child

    // constructor
    Tree(long value)
    {
        this.value = value;
    }

    // generate a balanced binary tree of depth k
    static Tree genTree(int k, int height)
    {
        if (k < 0)
        {
            return null;
        }

        Tree t = new Tree(++counter);
        t.level = height - k;
        t.left = genTree(k - 1, height);
        t.right = genTree(k - 1, height);
        return t;
    }

    // ========================================================================
    // traverse a tree sequentially

    long processTree()
    {
        return value 
            + ((left == null) ? 0 : left.processTree())
            + ((right == null) ? 0 : right.processTree());
    }

    // ========================================================================
    // traverse a tree parallel
    long processTreeParallel(TreeCalculation tc)
    {
        if (level < tc.levelParallel)
        {
            long leftResult = left.processTreeParallel(tc);
            long rightResult = right.processTreeParallel(tc);
            return value + leftResult + rightResult;
        }
        tc.incrementTasks();
        tc.cs.submit(new Callable<Long>()
        {
            @Override
            public Long call() throws Exception
            {
                return processTree();
            }
        });
        return 0;
    }
}