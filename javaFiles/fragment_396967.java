public class test{
    public void test(double[] args) throws IllegalArgumentException{
        for(int i = 0; i < args.length; i++){
            if(args[i] < 0) throw new IllegalArgumentException("Argument " + (i + 1) + " is negative");
        }
    }
}