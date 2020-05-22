public class Worker extends Task<Integer> {
    @Override
    protected Integer call(){
        for(int i = 1; i <= 1000000; i++)
            updateProgress(i, 1000000); 
        return 51;
    }
}