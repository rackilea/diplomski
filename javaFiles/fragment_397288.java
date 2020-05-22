import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ArraycopyStreamPerformance
{
    public static void main(String[] args)
    {
        basicTest();

        int runs = 100;
        int minNum = 2;
        int maxNum = 8;
        int minRows = 2;
        int maxRows = 20;
        int minCols = 100;
        int maxCols = 10000;
        for (int num = minNum; num <= maxNum; num *= 2)
        {
            for (int rows = minRows; rows <= maxRows; rows += 2)
            {
                for (int cols = minCols; cols <= maxCols; cols *= 10)
                {
                    runTest(num, rows, cols, runs);
                }
            }
        }
    }

    private static void runTest(int num, int rows, int cols, int runs)
    {
        int arrays[][][] = new int[num][rows][cols];

        long before = 0;
        long after = 0;

        int blackHole = 0;

        // arraycopy
        before = System.nanoTime();
        for (int i = 0; i < runs; i++)
        {
            int resultA[][] = combineRows(
                ArraycopyStreamPerformance::combineWithArraycopy, arrays);
            blackHole += resultA[0][0];
        }
        after = System.nanoTime();

        System.out.printf(Locale.ENGLISH, 
            "%2d arrays, %3d rows, %6d cols, arraycopy         : %8.3fms\n", 
            num, rows, cols, (after - before) / 1e6);


        // arraycopy parallel
        before = System.nanoTime();
        for (int i = 0; i < runs; i++)
        {
            int resultA[][] = combineRowsParallel(
                ArraycopyStreamPerformance::combineWithArraycopy, arrays);
            blackHole += resultA[0][0];
        }
        after = System.nanoTime();

        System.out.printf(Locale.ENGLISH, 
            "%2d arrays, %3d rows, %6d cols, arraycopy parallel: %8.3fms\n", 
            num, rows, cols, (after - before) / 1e6);


        // buffer
        before = System.nanoTime();
        for (int i = 0; i < runs; i++)
        {
            int resultB[][] = combineRows(
                ArraycopyStreamPerformance::combineWithBuffer, arrays);
            blackHole += resultB[0][0];
        }
        after = System.nanoTime();

        System.out.printf(Locale.ENGLISH, 
            "%2d arrays, %3d rows, %6d cols, buffer            : %8.3fms\n", 
            num, rows, cols, (after - before) / 1e6);


        // buffer parallel
        before = System.nanoTime();
        for (int i = 0; i < runs; i++)
        {
            int resultB[][] = combineRowsParallel(
                ArraycopyStreamPerformance::combineWithBuffer, arrays);
            blackHole += resultB[0][0];
        }
        after = System.nanoTime();

        System.out.printf(Locale.ENGLISH, 
            "%2d arrays, %3d rows, %6d cols, buffer    parallel: %8.3fms\n", 
            num, rows, cols, (after - before) / 1e6);


        // streams
        before = System.nanoTime();
        for (int i = 0; i < runs; i++)
        {
            int resultC[][] = combineRows(
                ArraycopyStreamPerformance::combineWithStreams, arrays);
            blackHole += resultC[0][0];
        }
        after = System.nanoTime();

        System.out.printf(Locale.ENGLISH, 
            "%2d arrays, %3d rows, %6d cols, stream            : %8.3fms (" + 
            blackHole + ")\n", num, rows, cols, (after - before) / 1e6);
    }



    private static void basicTest()
    {
        int array1[][] =
        {
            { 1, 2 },
            { 3, 4 },
            { 5, 6 } 
        };

        int array2[][] =
        {
            { 7, 8 },
            { 9, 1 },
            { 2, 3 } 
        };

        int result[][] =
        {
            { 1, 2, 7, 8 },
            { 3, 4, 9, 1 },
            { 5, 6, 2, 3 } 
        };
        System.out.println(Arrays.deepToString(result));

        int resultA[][] = combineRows(
            ArraycopyStreamPerformance::combineWithArraycopy, array1, array2);
        System.out.println(Arrays.deepToString(resultA));
        int resultB[][] = combineRows(
            ArraycopyStreamPerformance::combineWithBuffer, array1, array2);
        System.out.println(Arrays.deepToString(resultB));
        int resultC[][] = combineRows(
            ArraycopyStreamPerformance::combineWithStreams, array1, array2);
        System.out.println(Arrays.deepToString(resultC));
    }




    private static int[][] selectRows(int row, int[][]... arrays)
    {
        int result[][] = new int[arrays.length][];
        for (int j = 0; j < arrays.length; j++)
        {
            result[j] = arrays[j][row];
        }
        return result;
    }

    private static int[][] combineRows(
        Function<int[][], int[]> mergeFunction, int[][]... arrays)
    {
        int rows = arrays[0].length;
        int result[][] = new int[rows][];
        for (int i = 0; i < rows; i++)
        {
            result[i] = mergeFunction.apply(selectRows(i, arrays));
        }
        return result;
    }

    private static int[] combineWithArraycopy(int[]... arrays)
    {
        // Assuming the same length for all arrays!
        int length = arrays[0].length;
        int result[] = new int[arrays.length * length];
        for (int i = 0; i < arrays.length; i++)
        {
            System.arraycopy(arrays[i], 0, result, i * length, length);
        }
        return result;
    }

    private static int[] combineWithBuffer(int[]... arrays)
    {
        // Assuming the same length for all arrays!
        int length = arrays[0].length;
        int result[] = new int[arrays.length * length];
        IntBuffer buffer = IntBuffer.wrap(result);
        for (int i = 0; i < arrays.length; i++)
        {
            buffer.put(arrays[i]);
        }
        return result;
    }

    private static int[] combineWithStreams(int[] ... arrays)
    {
        return Stream.of(arrays).flatMapToInt(IntStream::of).toArray();
    }



    private static final ExecutorService EXECUTOR_SERVICE =
        createFixedTimeoutExecutorService(
            Runtime.getRuntime().availableProcessors(), 5, TimeUnit.SECONDS);

    public static ExecutorService createFixedTimeoutExecutorService(
        int poolSize, long keepAliveTime, TimeUnit timeUnit)
    {
        ThreadPoolExecutor e = 
            new ThreadPoolExecutor(poolSize, poolSize,
                keepAliveTime, timeUnit, new LinkedBlockingQueue<Runnable>());
        e.allowCoreThreadTimeOut(true);
        return e;
    }

    private static int[][] combineRowsParallel(
        Function<int[][], int[]> mergeFunction, int[][]... arrays)
    {
        int rows = arrays[0].length;
        int result[][] = new int[rows][];
        List<Callable<Object>> tasks = new ArrayList<Callable<Object>>();
        for (int i = 0; i < rows; i++)
        {
            int index = i;
            tasks.add(Executors.callable(() ->
            {
                result[index] = mergeFunction.apply(selectRows(index, arrays));
            }));
        }
        try
        {
            EXECUTOR_SERVICE.invokeAll(tasks);
        }
        catch (InterruptedException e)
        {
            Thread.currentThread().interrupt();
        }
        return result;
    }

}