public class PartialProcessing implements Callable<PartialResult> {
    int startJ;
    int endJ;

    ... other members needed for the computation such as
    int[] scalar;
    ...

    public PartialProcessing(int startJ, int endJ, ... others needed) {
        ...
    }

    int [] getARGB(Bitmap buf,int x, int y){
       ...
    }

    ... add other methods needed for the computation that where in class Filters

    // this will be called on some new thread
    @Override public PartialResult call() {
        PartialResult partialResult = new PartialResult(startJ, ...);
        p = ...; // not 0! at the start since we don't start at j = 0

        for (int j = startJ; j < (???<=) endJ; j++)
            for (int i... p++)
                ... copy the rest of the code

                partialResult.addResult(p, result);
    }
}